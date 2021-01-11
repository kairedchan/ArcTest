package com.greatmap.arc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.greatmap.arc.entity.ResultData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2021-01-11
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
public interface ITableService extends IService<ResultData> {

    boolean createTable(String tableName);

    boolean removeTable(String tableName);

    boolean insertCTID(List<ResultData> ctids, String tableName);

    boolean removeCTID(List<String> ctids, String tableName);

    List<String> getAllCTID(String tableName);

}
