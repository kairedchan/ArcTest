package com.greatmap.arc.ioc;

import org.springframework.stereotype.Service;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2020-12-22
 * Author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
@Service("personService")
public class PersonServiceImpl implements PersonService {
    
    private PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public void addPerson() {
        personDao.add();
        System.out.println("执行了addPerson()");
    }
}
