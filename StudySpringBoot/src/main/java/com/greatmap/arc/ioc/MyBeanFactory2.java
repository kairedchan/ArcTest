package com.greatmap.arc.ioc;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2020-12-22
 * Author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
public class MyBeanFactory2 {

    public MyBeanFactory2() {
        System.out.println("实例化工厂类");
    }
    
    public Person createPerson() {
        System.out.println("构建person类");
        return new Person();
    }
}
