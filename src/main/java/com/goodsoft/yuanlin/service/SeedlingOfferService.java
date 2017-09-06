package com.goodsoft.yuanlin.service;

import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.web.multipart.MultipartFile;

/**
 * function 苗木参考报价业务接口类
 * Created by 严彬荣 on 2017/9/4.
 * version v1.0
 */
public interface SeedlingOfferService {
    //查询苗木参考数据
    public <T> T querySeedlingOfferService(String price, String mate, String tp, String spf, String date, String page);

    public Status addSeedlingOfferService(MultipartFile[] files);
}
