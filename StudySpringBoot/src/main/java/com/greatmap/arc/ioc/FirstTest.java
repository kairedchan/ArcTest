package com.greatmap.arc.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2020-12-22
 * Author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
public class FirstTest {

    public void test1() {
        String xmlPath = "ApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        PersonDao personDao = (PersonDao) applicationContext.getBean("PersonDao");
        personDao.add();

    }

}
