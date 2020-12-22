package com.greatmap.arc.annotation;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2020-12-22
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Resource(name = "personDao")
    private PersonDao personDao;
    
    public PersonDao getPersonDao() {
        return personDao;
    }
    
    @Override
    public void add() {
        System.out.println("执行了service的add()");
        personDao.add();
    }
}
