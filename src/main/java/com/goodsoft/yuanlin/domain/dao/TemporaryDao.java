package com.goodsoft.yuanlin.domain.dao;

import com.goodsoft.yuanlin.domain.entity.user.Corporation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 导入数据到法人库临时接口类
 * Created by 严彬荣 on 2017/9/28.
 */
@Repository
public interface TemporaryDao {

    public void temporaryDao(List<Corporation> data) throws Exception;
}
