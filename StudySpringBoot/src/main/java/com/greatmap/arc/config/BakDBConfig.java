package com.greatmap.arc.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@MapperScan(basePackages = "com.greatmap.arc.mapper.bak", sqlSessionTemplateRef  = "bakSqlSessionTemplate")
public class BakDBConfig {

    @Bean(name = "bakDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.bak")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "bakSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("bakDataSource") DataSource dataSource)
            throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/bak/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "bakTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("bakDataSource")
                                                                       DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "bakSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("bakSqlSessionFactory") SqlSessionFactory
                                                             sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
