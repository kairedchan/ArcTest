package com.greatmap.arc.annotation;


import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2020-12-22
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
@Controller("personAction")
public class PersonAction {

    @Resource(name = "personService")
    private PersonService personService;

    public PersonService getPersonService() {
        return personService;
    }

    public void add() {
        System.out.println("执行Action层的add方法");
        personService.add();
    }
}
