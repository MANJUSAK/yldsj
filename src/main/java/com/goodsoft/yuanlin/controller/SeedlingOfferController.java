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

    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/find/mmckbj")
    public Object querySeedlingOfferController(String price, String mate, String tp, String spf, String date, String page) {
        return this.service.querySeedlingOfferService(price, mate, tp, spf, date, page);
    }

    @RequestMapping("/add/mmckbj")
    public Status addSeedlingOfferController(@RequestParam("files") MultipartFile[] files) {
        return this.service.addSeedlingOfferService(files);
    }
}
