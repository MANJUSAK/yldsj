package com.goodsoft.yuanlin.controller;


import com.goodsoft.yuanlin.util.AuthCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * function 验证码访问入口Java类
 * <p>
 * date 2017.03.02
 *
 * @author 严彬荣
 */
@Controller
public class AuthCodeController {

    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpSession session;
    private AuthCodeUtil authCode = AuthCodeUtil.getInstance();

    // 验证码接口
    @RequestMapping("/authCode")
    public void AuthCode(HttpServletResponse response) {
        try {
            this.authCode.getAuthCode(request, response, session);
        } catch (IOException e) {
            System.out.println(e.toString());

        }
    }
}
