package com.goodsoft.yuanlin.controller;

import com.goodsoft.yuanlin.service.SeedlingOfferService;
import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * function 苗木参考报价访问接口
 * Created by 严彬荣 on 2017/9/4.
 * version v1.0
 */
@RestController
@RequestMapping("/offer")
public class SeedlingOfferController {

    @Resource
    private SeedlingOfferService service;

    /**
     * 苗木参考报价查询接口
     *
     * @param price   价格
     * @param keyWord 名称
     * @param tp      类型
     * @param spf     规格
     * @param date    时间
     * @param page    页码
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/find/mmckbj")
    public Object querySeedlingOfferController(String price, String keyWord, String tp, String spf, String date, String page) {
        return this.service.querySeedlingOfferService(price, keyWord, tp, spf, date, page);
    }

    /**
     * 添加苗木参考报价接口
     *
     * @param files excel文件
     * @return 响应结果
     */
    @RequestMapping("/add/mmckbj")
    public Status addSeedlingOfferController(@RequestParam("files") MultipartFile[] files) {
        return this.service.addSeedlingOfferService(files);
    }
}
