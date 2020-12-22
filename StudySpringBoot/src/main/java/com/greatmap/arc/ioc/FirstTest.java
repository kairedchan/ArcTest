package com.greatmap.arc.ioc;

import com.greatmap.arc.annotation.PersonAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2020-12-22
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
public class FirstTest {

    @Test
    public void test1() {
        // 依赖注入, 通过ClassPathXmlApplicationContext读取ApplicationContext.xml内容,从而创建对象
        // 实现此操作需要保证类必须有一个无参构造器
        // 将类的创建由开发者转交给容器的思想称之为控制反转
        String xmlPath = "ApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        PersonDao personDao = (PersonDao) applicationContext.getBean("personDao");
        personDao.add();

    }

    @Test
    public void test2() {
        String xmlPath = "ApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        PersonService personService = (PersonService) applicationContext.getBean("personService");
        personService.addPerson();
        System.out.println(applicationContext.getBean("person2"));
        System.out.println(applicationContext.getBean("person3"));
        System.out.println(applicationContext.getBean("person3"));
    }

    @Test
    public void test3() {
        String xmlPath = "ApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        System.out.println(applicationContext.getBean("person"));
    }

    @Test
    public void test4() {
        // 定义Spring配置文件路径
        String xmlPath = "ApplicationContext2.xml";
        // 初始化Spring容器，加载配置文件，并对bean进行实例化
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                xmlPath);
        // 获得personAction实例
        PersonAction personAction = (PersonAction) applicationContext.getBean("personAction");
        // 调用personAction中的add()方法
        personAction.add();
    }

}
