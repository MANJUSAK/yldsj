package com.goodsoft.yuanlin.config.mybatis;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * function 配置mybatis包扫描
 * Created by 严彬荣 on 2017/8/3.
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MybatisScannerConfig {

    @Bean(name = "mapperScannerConfigurer")
    public static MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.goodsoft.yuanlin.dao");
        return mapperScannerConfigurer;
    }
}
