package com.goodsoft.yuanlin.controller;

import com.goodsoft.yuanlin.domain.entity.user.SignIn;
import com.goodsoft.yuanlin.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * function 用户管理访问入口
 * Created by 严彬荣 on 2017/8/10.
 * version v1.0
 */
@RestController
public class UserController {
    @Resource
    private UserService service;

    /**
     * pc端用户授权接口
     *
     * @param request  http请求,
     * @param userName 用户名
     * @param passWord 密码
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object queryUserController(HttpServletRequest request, String userName, String passWord) {
        return this.service.queryUserService(request, userName, passWord, "noUserCode");
    }

    /**
     * app端用户授权接口
     *
     * @param request  http请求,
     * @param userName 用户名
     * @param passWord 密码
     * @param userCode 用户验证码
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/app/login", method = RequestMethod.POST)
    public Object queryUserController(HttpServletRequest request, String userName, String passWord, String userCode) {
        return this.service.queryUserService(request, userName, passWord, userCode);
    }

    /**
     * 查询用户签到数据接口
     *
     * @param uid  用户编号，
     * @param dept 企业，
     * @param page 页数。
     * @param comp 所属企业
     * @param dep  部门
     * @param dept 是否为人事部
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping(value = "/find/signIn")
    public Object querySignInController(String uid, String dept, String dep, String comp, String page, String lev) {
        return this.service.querySignInService(uid, dept, dep, comp, page, lev);
    }

    /**
     * 查询人才库数据访问接口
     *
     * @param type 查询类型（法人库等）
     * @param page 页数
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping(value = "/rck/find/{type}")
    public Object queryTalentPoolController(@PathVariable("type") String type, String page) {
        return this.service.queryTalentPoolService(type, page);
    }

    /**
     * 用户签到接口
     *
     * @param msg 用户信息
     * @return 响应结果
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public Object SignInController(SignIn msg) {
        return this.service.signInService(msg);
    }
}