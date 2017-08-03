package com.goodsoft.yuanlin.dao;

import com.goodsoft.yuanlin.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * function 用户管理dao层
 * Created by 严彬荣 on 2017/8/3.
 */
@Repository
public interface UserDao {
    public List queryUser();

    public int insertUser(User var) throws Exception;
}
