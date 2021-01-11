package com.greatmap.arc.mapper.recode;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greatmap.arc.entity.ResultData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2021-01-08
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description  用来进行表的新增, 删除, 插入 等综合操作
 **/
public interface TableMapper extends BaseMapper {

    /**
     * 创建表
     * @param tableName
     * @return
     */
    boolean createTable(@Param("tableName") String tableName);

    /**
     * 删除表
     * @param tableName
     * @return
     */
    boolean removeTable(@Param("tableName") String tableName);

    /**
     * 批量插入数据
     * @param ctids
     * @return
     */
    boolean insertCTID(@Param("ctids") List<ResultData> ctids, @Param("tableName") String tableName);

    /**
     * 移除数据
     * @param ctids
     * @param tableName
     * @return
     */
    boolean removeCTID(@Param("ctids") List<String> ctids, @Param("tableName") String tableName);

    /**
     * 获取该表的所有数据
     * @param tableName
     * @return
     */
    List<String> getAllCTID(@Param("tableName") String tableName);

}
