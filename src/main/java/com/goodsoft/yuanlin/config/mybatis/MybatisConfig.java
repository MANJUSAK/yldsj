package com.goodsoft.yuanlin.config.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * function mybatis配置属性
 * Created by 严彬荣 on 2017/8/3.
 */
@EnableTransactionManagement
@Configuration
public class MybatisConfig {

    @Resource
    private DruidDataSource druidDataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setLogImpl(org.apache.ibatis.logging.slf4j.Slf4jImpl.class);//use slf4j log
        configuration.setUseColumnLabel(true);
        configuration.setUseGeneratedKeys(true);
        configuration.setMapUnderscoreToCamelCase(true);
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(druidDataSource);
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath*:static/mapper/*.xml"));
        return sqlSessionFactory;
    }
}
