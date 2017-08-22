package com.goodsoft.yuanlin.controller;

import com.goodsoft.yuanlin.domain.entity.trade.*;
import com.goodsoft.yuanlin.service.TradeManageService;
import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * function 行业协会访问入口
 * Created by 严彬荣 on 2017/8/21.
 */
@RestController
@RequestMapping("/hyxh")
public class TradeManageController {

    @Resource
    private TradeManageService service;

    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/find/cont/{type}")
    public Object queryTradeController(HttpServletRequest request, @PathVariable("type") String type, String page) {
        return this.service.queryTradeService(request, type, page);
    }

    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/find/{type}")
    public Object queryTradeController(@PathVariable("type") String type, String member, String page) {
        return this.service.queryTradeService(type, page, member);
    }

    @RequestMapping(value = "/add/hf", method = RequestMethod.POST)
    public Status addTradeController(Dues msg) {
        return this.service.addTradeService("hf", msg);
    }

    @RequestMapping(value = "/add/lxxh", method = RequestMethod.POST)
    public Status addTradeController(Contact msg) {
        return this.service.addTradeService("lxxh", msg);
    }

    @RequestMapping(value = "/add/dtzx", method = RequestMethod.POST)
    public Status addTradeController(Information msg) {
        return this.service.addTradeService("dtzx", msg);
    }

    @RequestMapping(value = "/add/yzgc", method = RequestMethod.POST)
    public Status addQualEnginController(QualEngin msg) {
        return this.service.addTradeService("yzgc", msg);
    }

    @RequestMapping(value = "/add/xhpx", method = RequestMethod.POST)
    public Status addController(HttpServletRequest request, @RequestParam("files") MultipartFile[] files, String fileType, TrainsInfo msg) {
        return this.service.addTradeService(request, files, fileType, "xhpx", msg);
    }
}
