package com.goodsoft.yuanlin;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * function 系统启动程序入口
 * Created by 严彬荣 on 2017/8/4.
 */


@ComponentScan(basePackages = "com.goodsoft.yuanlin")
@ServletComponentScan(basePackages = "com.goodsoft.yuanlin.config")
@SpringBootApplication
public class YldsjApplication {
    private Logger logger = Logger.getLogger(YldsjApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(YldsjApplication.class, args);
    }
}
