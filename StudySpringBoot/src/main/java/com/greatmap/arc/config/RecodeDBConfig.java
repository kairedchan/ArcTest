package com.greatmap.arc.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2021-01-07
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/

@Configuration
@MapperScan(basePackages = "com.greatmap.arc.mapper.recode", sqlSessionTemplateRef  = "recodeSqlSessionTemplate")
public class RecodeDBConfig {


    @Primary
    @Bean(name = "recodeDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.recode")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "recodeSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("recodeDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/recode/*.xml"));
        return bean.getObject();
    }

    @Primary
    @Bean(name = "recodeTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("recodeDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "recodeSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("recodeSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
