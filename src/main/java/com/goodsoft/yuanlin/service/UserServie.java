package com.goodsoft.yuanlin.service;

import com.goodsoft.yuanlin.entity.User;

import java.util.List;

/**
 * function 用户管理接口
 * Created by 严彬荣 on 2017/8/3.
 */
public interface UserServie {
    public List queryService();

    public String insertUser(User var);
}
