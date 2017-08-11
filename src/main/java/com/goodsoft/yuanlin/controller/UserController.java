package com.goodsoft.yuanlin.controller;

import com.goodsoft.yuanlin.domain.entity.user.User;
import com.goodsoft.yuanlin.service.UserService;
import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * function 用户管理访问入口
 * Created by 严彬荣 on 2017/8/10.
 */
@RestController
public class UserController {
    @Resource
    private UserService service;
    /*@Resource
    private HttpServletRequest req;*/

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object queryUserController(HttpServletRequest request, String userName, String passWord, String userCode) {
        return this.service.queryUserService(request, userName, passWord, userCode);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Status addUserController(@RequestParam("files") MultipartFile[] files, HttpServletRequest request, User msg, String userCode) {
        return this.service.addUserService(files, request, msg, userCode);
    }
}
