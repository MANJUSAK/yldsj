package com.goodsoft.yuanlin.controller;

import com.goodsoft.yuanlin.domain.entity.user.SignIn;
import com.goodsoft.yuanlin.domain.entity.user.User;
import com.goodsoft.yuanlin.service.UserService;
import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.web.bind.annotation.*;
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

    /**
     * pc端用户授权接口
     *
     * @param request http请求,
     *                userName 用户名
     *                passWord 密码
     *                userCode 用户验证码
     * @return 用户登录结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object queryUserController(HttpServletRequest request, String userName, String passWord) {
        return this.service.queryUserService(request, userName, passWord, "noUserCode");
    }

    /**
     * app端用户授权接口
     *
     * @param request http请求,
     *                userName 用户名
     *                passWord 密码
     *                userCode 用户验证码
     * @return 用户登录结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/app/login", method = RequestMethod.POST)
    public Object queryUserController(HttpServletRequest request, String userName, String passWord, String userCode) {
        return this.service.queryUserService(request, userName, passWord, userCode);
    }

    /**
     * 查询用户签到数据接口
     *
     * @param uid 用户编号，
     *            deptId 企业id，
     *            page 页数。
     * @return 查询结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping(value = "/find/signIn")
    public Object querySignInController(String uid, String deptId, String page) {
        return this.service.querySignInService(uid, deptId, page);
    }

    /**
     * 用户签到接口
     *
     * @param msg 用户信息
     * @return 签到结果
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public Object SignInController(SignIn msg) {
        return this.service.signInService(msg);
    }


    /**
     * 增加用户接口
     *
     * @param request http请求,
     *                files 用户文件
     *                msg 用户信息
     *                userCode 用户验证码
     * @return 增加用户结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Status addUserController(@RequestParam("files") MultipartFile[] files, HttpServletRequest request, User msg, String userCode) {
        return this.service.addUserService(files, request, msg, userCode);
    }
}