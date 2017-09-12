package com.goodsoft.yuanlin.service;

import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * function 行业协会业务接口类
 * Created by 严彬荣 on 2017/8/21.
 * version v1.0
 */
public interface TradeManageService {

    //查询行业协会数据（有文件）
    public <T> T queryTradeService(HttpServletRequest request, String type, String date, String tp, String keyWord, String page);

    //查询行业协会数据（无文件）
    public <T> T queryTradeService(String type, String page, String date, String tp, String comp, String year, String keyWord, String member);

    //增加行业协会数据(有文件)
    public Status addTradeService(MultipartFile[] files, String fileType, String type, Object msg);

    //增加行业协会数据(无文件)
    public Status addTradeService(String type, Object msg);

    //删除行业协会数据
    public Status deleteTradeService(String type, String[] id);

}
