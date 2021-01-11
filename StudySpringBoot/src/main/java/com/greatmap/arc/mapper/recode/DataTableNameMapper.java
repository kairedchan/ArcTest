package com.greatmap.arc.mapper.recode;

import com.greatmap.arc.entity.DataTableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 表名库,存储所有的表名 Mapper 接口
 * </p>
 *
 * @author ckh
 * @since 2021-01-08
 */
public interface DataTableNameMapper extends BaseMapper<DataTableName> {

    /**
     * 获取记录表中的所有记录的表名
     * @return
     */
    List<String> getRecodeTableName();

}
