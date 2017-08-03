package com.goodsoft.yuanlin;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@ComponentScan(basePackages = "com.goodsoft.yuanlin")
@ServletComponentScan(basePackages = "com.goodsoft.yuanlin.config")
@SpringBootApplication
public class YldsjApplication {
    private Logger logger = Logger.getLogger(YldsjApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(YldsjApplication.class, args);
    }
}
