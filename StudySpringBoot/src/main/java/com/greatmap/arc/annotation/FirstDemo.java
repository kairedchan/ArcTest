package com.greatmap.arc.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2020-12-22
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
public class FirstDemo {

    @Test
    public void test() {
        // 定义Spring配置文件路径
        String xmlPath = "ApplicationContext2.xml";
        // 初始化Spring容器，加载配置文件，并对bean进行实例化
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                xmlPath);
        // 获得personAction实例
        PersonAction personAction = (PersonAction) applicationContext
                .getBean("personAction");
        // 调用personAction中的add()方法
        personAction.add();
    }

}
