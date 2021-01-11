package com.greatmap.arc.service;

import com.greatmap.arc.entity.DataChange;

import java.util.List;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2021-01-08
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
public interface IDataProcessService {

    /**
     * 获取备份库所有表名
     * @return
     */
    List<String> getBakAllTableName();

    /**
     * 获取记录库t_data_table_name表中所有的表名
     * @return
     */
    List<String> getRecodeTableNames();

    /**
     * 添加修改表名的记录到库中
     * @param tableNames    修改的表名集合
     * @param changeType    修改类型
     * @return
     */
    boolean addChangeTableRecode(List<String> tableNames, Integer changeType);

    /**
     * 添加修改表数据的记录到库中, 此处做一个待处理, 当集合数量超过一千时在一起提交到数据库
     * @param dataChanges
     * @param tableName
     * @param changeType
     * @param fastFlush   是否立即提交, 如果这里配置了false, 则在程序结束之前一定要执行 flush 方法;
     * @return
     */
    boolean addChangeTableDataRecode(List<String> dataChanges, String tableName,
                                     Integer changeType, boolean fastFlush);

    /**
     * 此方法与addChangeTableDataRecode联动, 请务必在操作结束执行该方法,否则数据提交不完全
     * @return
     */
    boolean flush();

    /**
     * 删除数据信息
     * @param tableNames
     * @return
     */
    boolean addChangeTableData(List<String> tableNames, Integer changeType);

    /**
     * 删除表
     * @param tableNames
     * @return
     */
    boolean dropTable(List<String> tableNames);

    /**
     * 新建表
     * @param tableNames
     * @return
     */
    boolean createTable(List<String> tableNames);

    /**
     * 获取备份库表中的ctid数据
     * @param tableName
     * @return
     */
    List<String> getBakTableData(String tableName);

    /**
     * 获取记录库中的表的ctid数据
     * @param tableName
     * @return
     */
    List<String> getRecodeTableData(String tableName);

    /**
     * 移除表中数据
     * @param tableName
     * @param datas
     * @return
     */
    boolean removeTableData(String tableName, List<String> datas);

    /**
     * 添加表中的数据
     * @param tableName
     * @param datas
     * @return
     */
    boolean createTableData(String tableName, List<String> datas);
}
