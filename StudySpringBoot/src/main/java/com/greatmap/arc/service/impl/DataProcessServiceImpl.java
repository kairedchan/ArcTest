package com.greatmap.arc.service.impl;

import com.greatmap.arc.entity.DataChange;
import com.greatmap.arc.entity.DataTableName;
import com.greatmap.arc.mapper.bak.TResultStrMapper;
import com.greatmap.arc.mapper.recode.TableMapper;
import com.greatmap.arc.service.IDataChangeService;
import com.greatmap.arc.service.IDataProcessService;
import com.greatmap.arc.service.IDataTableNameService;
import com.greatmap.arc.simple.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2021-01-08
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
@Service
public class DataProcessServiceImpl implements IDataProcessService {

    private List<DataChange> priDataChanges = new ArrayList<>();

    @Autowired
    TResultStrMapper tResultStrMapper;

    @Autowired
    IDataTableNameService dataTableNameService;

    @Autowired
    IDataChangeService dataChangeService;

    @Autowired
    TableMapper tableMapper;

    @Override
    public List<String> getBakAllTableName() {
        return tResultStrMapper.getAllTableName();
    }

    @Override
    public List<String> getRecodeTableNames() {
        return dataTableNameService.getRecodeTableName();
    }

    @Override
    public boolean addChangeTableRecode(List<String> tableNames, Integer changeType) {
        List<DataChange> dataChanges = tableNames.stream().map(tableName ->
                new DataChange(null, changeType, tableName, null, LocalDateTime.now()))
                .collect(Collectors.toList());
        return dataChangeService.saveBatch(dataChanges);
    }

    @Override
    public boolean addChangeTableData(List<String> tableNames, Integer changeType) {
        if (Constant.DELETE_CODE.equals(changeType)) {
            return dataTableNameService.removeByTableNames(tableNames);
        } else if (Constant.INSERT_CODE.equals(changeType)) {
            return dataTableNameService.saveBatch(tableNames.stream().map(tableName ->
                    new DataTableName(null, tableName)).collect(Collectors.toList()));
        }
        return false;
    }

    @Override
    public boolean addChangeTableDataRecode(List<String> dataChanges, String tableName,
                                            Integer changeType, boolean fastFlush) {
        boolean result = true;
        List<DataChange> datas = dataChanges.stream().map(ctid -> new DataChange(null, changeType, tableName, ctid, LocalDateTime.now()))
                .collect(Collectors.toList());
        priDataChanges.addAll(datas);

        if (fastFlush || priDataChanges.size() >= Constant.INSERT_SIZE) {
            result = dataChangeService.saveBatch(priDataChanges);
            priDataChanges.clear();
        }
        return result;
    }

    @Override
    public boolean flush() {
        return dataChangeService.saveBatch(priDataChanges);
    }

    @Override
    public boolean dropTable(List<String> tableNames) {
        return dataTableNameService.removeByTableNames(tableNames);
    }

    @Override
    public boolean createTable(List<String> tableNames) {
        boolean result = true;
        for (String tableName : tableNames) {
            result = tableMapper.createTable(tableName) && result;
        }
        return result;
    }

    @Override
    public List<String> getBakTableData(String tableName) {
        return tResultStrMapper.getAllCTID(tableName);
    }

    @Override
    public List<String> getRecodeTableData(String tableName) {
        return tableMapper.getAllCTID(tableName);
    }

    @Override
    public boolean removeTableData(String tableName, List<String> datas) {
        if (datas.size() == 0) return true;
        return tableMapper.removeCTID(datas, tableName);
    }

    @Override
    public boolean createTableData(String tableName, List<String> datas) {
        if (datas.size() == 0) return true;
        return tableMapper.insertCTID(datas, tableName);
    }
}
