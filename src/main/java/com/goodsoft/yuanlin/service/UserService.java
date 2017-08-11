package com.goodsoft.yuanlin.service;

import com.goodsoft.yuanlin.domain.entity.user.User;
import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * function 用户管理业务接口
 * Created by 严彬荣 on 2017/8/10.
 */
public interface UserService {

    //用户登录
    public <T> T queryUserService(HttpServletRequest request, String userName, String passWord, String userCode);

    //添加用户信息
    public Status addUserService(MultipartFile[] files, HttpServletRequest request, User msg, String userCode);
}
