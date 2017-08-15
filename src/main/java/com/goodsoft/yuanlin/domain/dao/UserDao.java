package com.goodsoft.yuanlin.domain.dao;

import com.goodsoft.yuanlin.domain.entity.user.SignIn;
import com.goodsoft.yuanlin.domain.entity.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * function 用户管理dao层
 * Created by 严彬荣 on 2017/8/10.
 */

@Repository
public interface UserDao {

    //用户登录
    public User queryUserDao(@Param("userName") String userName, @Param("passWord") String passWord);

    //用户签到
    public void signInDao(SignIn msg) throws Exception;

    //用户签到信息
    public List<SignIn> querySignInDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page);

    //检索用户名是否存在
    public int queryUserByNameDao(@Param("userName") String userName);

    //获取部门id
    public String queryDeptByNameDao(@Param("dept") String dept);

    //获取部门权限等级
    public String queryDeptLevelByIdDao(@Param("deptId") String deptId);

    //获取用户所在部门id
    public String queryDeptIdByUidDao(@Param("uid") String uid);

    //添加用户信息
    public void addUserDao(User user) throws Exception;

    //添加用户到部门
    public void addDeptDao(@Param("id") String id, @Param("uid") String uid, @Param("deptId") String deptId, @Param("time") String time);
}
