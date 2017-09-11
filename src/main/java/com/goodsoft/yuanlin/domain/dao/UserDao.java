package com.goodsoft.yuanlin.domain.dao;

import com.goodsoft.yuanlin.domain.entity.user.Corporation;
import com.goodsoft.yuanlin.domain.entity.user.Employees;
import com.goodsoft.yuanlin.domain.entity.user.SignIn;
import com.goodsoft.yuanlin.domain.entity.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * function 用户管理dao层
 * Created by 严彬荣 on 2017/8/10.
 * version v1.0
 */

@Repository
public interface UserDao {

    //用户登录
    public User queryUserDao(@Param("userName") String userName, @Param("passWord") String passWord) throws Exception;

    //用户签到
    public void signInDao(SignIn msg) throws Exception;

    //用户签到信息
    public List<SignIn> querySignInDao(@Param("uid") String uid, @Param("dept") String dept, @Param("comp") String comp, @Param("page") int page) throws Exception;

    //法人库数据
    public List<Corporation> queryCorporationDao(@Param("page") int page) throws Exception;

    //从业人员库数据
    public List<Employees> queryEmployeesDao(@Param("page") int page) throws Exception;
}
