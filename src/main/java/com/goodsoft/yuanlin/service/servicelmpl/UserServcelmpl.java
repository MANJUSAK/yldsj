package com.goodsoft.yuanlin.service.servicelmpl;

import com.goodsoft.yuanlin.entity.User;
import com.goodsoft.yuanlin.dao.UserDao;
import com.goodsoft.yuanlin.service.UserServie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * function 用户管理接口实现类
 * Created by 严彬荣 on 2017/8/3.
 */
@Service
public class UserServcelmpl implements UserServie {
    @Resource
    private UserDao dao;

    @Override
    public List queryService() {
        List data = this.dao.queryUser();
        return data;
    }

    @Override
    @Transactional
    public String insertUser(User var) {
        int i = 0;
        try {
            i = this.dao.insertUser(var);
        } catch (Exception e) {
            e.printStackTrace();
            return "服务器繁忙";
        }
        if (i > 0) {
            return "添加成功";
        }
        return "添加失败";
    }
}
