package com.greatmap.arc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.greatmap.arc.entity.DataTableName;

import java.util.List;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2021-01-08
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
public interface IDataTableNameService extends IService<DataTableName> {

    List<String> getRecodeTableName();

    boolean removeByTableNames(List<String> tableNames);
}
