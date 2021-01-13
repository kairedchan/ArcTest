package com.greatmap.arc.mapper.bak;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2021-01-07
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
@Component
public interface TResultStrMapper extends BaseMapper<String> {

    /**
     * 获取所有的表名
     * @return
     */
    List<String> getAllTableName();

    /**
     * 获取所有的数据的CTID, 根据传入的表名
     * @param tableName 表名
     * @return
     */
    List<String> getAllCTID(@Param("tableName") String tableName);

    /**
     * 获取控件数据的SRID
     * @param tableName
     * @return
     */
    List<String> getAllSrid(@Param("tableName") String tableName);

}
