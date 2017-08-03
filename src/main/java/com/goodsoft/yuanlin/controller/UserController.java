package com.goodsoft.yuanlin.controller;

import com.goodsoft.yuanlin.entity.User;
import com.goodsoft.yuanlin.service.UserServie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * function 用户管理访问入口
 * Created by ASUS on 2017/8/3.
 */
@RestController
public class UserController {

    @Resource
    private UserServie servie;

    @RequestMapping("/queryUser")
    public List userController() {
        return this.servie.queryService();
    }

    @RequestMapping("/insertUser")
    public String userController(User var) {
        return this.servie.insertUser(var);
    }
}
