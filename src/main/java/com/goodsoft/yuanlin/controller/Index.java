package com.goodsoft.yuanlin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ASUS on 2017/8/3.
 */
@Controller
public class Index {
    @RequestMapping("/index")
    public String index() {
        return "/index";
    }
}
