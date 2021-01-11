package com.greatmap.arc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatmap.arc.entity.DataTableName;
import com.greatmap.arc.mapper.recode.DataTableNameMapper;
import com.greatmap.arc.service.IDataTableNameService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2021-01-08
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
@Service
public class DataTableNameServiceImpl extends ServiceImpl<DataTableNameMapper, DataTableName> implements IDataTableNameService {

    @Override
    public List<String> getRecodeTableName() {
        return baseMapper.getRecodeTableName();
    }

    @Override
    public boolean removeByTableNames(List<String> tableNames) {
        tableNames.forEach(tableName -> {
            QueryWrapper<DataTableName> wr = new QueryWrapper<>();
            wr.eq("table_name", tableName);
            baseMapper.delete(wr);
        });
        return true;
    }
}
