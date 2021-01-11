package com.greatmap.arc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatmap.arc.entity.ResultData;
import com.greatmap.arc.mapper.recode.TableMapper;
import com.greatmap.arc.service.ITableService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2021-01-11
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
@Service
public class TableServiceImpl extends ServiceImpl<TableMapper, ResultData> implements ITableService {
    @Override
    public boolean createTable(String tableName) {
        return baseMapper.createTable(tableName);
    }

    @Override
    public boolean removeTable(String tableName) {
        return baseMapper.removeTable(tableName);
    }

    @Override
    public boolean insertCTID(List<ResultData> ctids, String tableName) {
        return baseMapper.insertCTID(ctids, tableName);
    }

    @Override
    public boolean removeCTID(List<String> ctids, String tableName) {
        return baseMapper.removeCTID(ctids, tableName);
    }

    @Override
    public List<String> getAllCTID(String tableName) {
        return getAllCTID(tableName);
    }
}
