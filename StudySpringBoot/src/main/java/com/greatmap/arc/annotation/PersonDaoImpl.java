package com.greatmap.arc.annotation;

import org.springframework.stereotype.Repository;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2020-12-22
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

    @Override
    public void add() {
        System.out.println("执行了dao的add()");
    }

}
