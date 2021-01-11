package com.greatmap.arc.config;

import com.greatmap.arc.service.IDataProcessService;
import com.greatmap.arc.simple.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2021-01-11
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
@Configuration
@EnableScheduling
public class StaticScheduleTask {

    @Autowired
    IDataProcessService dataProcessService;

    @Scheduled(fixedRate = 5000)
    public void process() {

        System.out.println("执行静态定时任务时间:" + LocalDateTime.now());

        // 表级别的记录修改
        List<String> allTableName = processTable();

        // ====================== 数据级别的记录修改==============================
        allTableName.forEach(tableName -> {
            List<String> recodeTableData = dataProcessService.getRecodeTableData(tableName);
            List<String> bakTableData = dataProcessService.getBakTableData(tableName);
            List<String> temp = new ArrayList<>();
            temp.addAll(recodeTableData);

            // 得到删除的数据
            recodeTableData.removeAll(bakTableData);
            // 添加删除记录
            dataProcessService.addChangeTableDataRecode(recodeTableData,
                    tableName, Constant.DELETE_CODE, false);
            // 同步表数据
            dataProcessService.removeTableData(tableName, recodeTableData);

            // 得到新增数据
            bakTableData.removeAll(temp);
            // 同步新增记录
            dataProcessService.addChangeTableDataRecode(bakTableData,
                    tableName, Constant.INSERT_CODE, false);
            // 同步表数据
            dataProcessService.createTableData(tableName, bakTableData);
        });

        // 提交所有数据
        dataProcessService.flush();
        System.out.println("定时任务执行完毕");
    }

    private List<String> processTable() {
        List<String> bakAllTableName = dataProcessService.getBakAllTableName();
        List<String> recodeTableNames = dataProcessService.getRecodeTableNames();

        // 去掉系统表
        bakAllTableName.removeAll(Constant.PGTABLE_NAME);

        List<String> temp = new ArrayList<>();
        List<String> allTableName = new ArrayList<>();
        temp.addAll(recodeTableNames);
        allTableName.addAll(bakAllTableName);

        // ====================== 表级别的记录修改=============================

        // 得到删除之后的信息
        recodeTableNames.removeAll(bakAllTableName);
        // 添加删除记录
        dataProcessService.addChangeTableRecode(recodeTableNames, Constant.DELETE_CODE);
        // 同步表名库
        dataProcessService.addChangeTableData(recodeTableNames, Constant.DELETE_CODE);
        // 删除同名表
        dataProcessService.dropTable(recodeTableNames);

        // 得到新增的表信息
        bakAllTableName.removeAll(temp);
        // 添加新增记录
        dataProcessService.addChangeTableRecode(bakAllTableName, Constant.INSERT_CODE);
        // 同步表名库
        dataProcessService.addChangeTableData(bakAllTableName, Constant.INSERT_CODE);
        // 创建同名表
        dataProcessService.createTable(bakAllTableName);
        return allTableName;
    }

}
