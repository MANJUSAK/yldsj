package com.goodsoft.yuanlin.service;

import com.goodsoft.yuanlin.domain.entity.user.SignIn;
import com.goodsoft.yuanlin.util.resultentity.Status;

import javax.servlet.http.HttpServletRequest;

/**
 * function 用户管理业务接口
 * Created by 严彬荣 on 2017/8/10.
 * version v1.0
 */
public interface UserService {

    //用户登录
    public <T> T queryUserService(HttpServletRequest request, String userName, String passWord, String userCode);

    //用户签到
    public Status signInService(SignIn msg);

    //用户签到数据
    public <T> T querySignInService(String uid, String dept, String dep, String comp, String page, String lev);

    //查询人才库数据
    public <T> T queryTalentPoolService(String tp, String page);
}
