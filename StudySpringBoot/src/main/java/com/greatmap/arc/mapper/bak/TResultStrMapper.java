package com.greatmap.arc.mapper.bak;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

    List<String> getTableName();

}
