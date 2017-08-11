package com.goodsoft.yuanlin.domain.dao;

import com.goodsoft.yuanlin.domain.entity.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * function 用户管理dao层
 * Created by 严彬荣 on 2017/8/10.
 */

@Repository
public interface UserDao {

    //用户登录
    public User queryUserDao(@Param("userName") String userName, @Param("passWord") String passWord);

    //检索用户名是否存在
    public int queryUserByNameDao(@Param("userName") String userName);

    //获取部门id
    public String queryDeptByIdDao(@Param("dept") String dept);

    //添加用户信息
    public void addUserDao(User user) throws Exception;

    //添加用户到部门
    public void addDeptDao(@Param("id") String id, @Param("uid") String uid, @Param("deptId") String deptId, @Param("time") String time);
}
