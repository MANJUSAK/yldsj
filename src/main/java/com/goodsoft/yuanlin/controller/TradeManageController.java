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
 * version v1.0
 */
@CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
@RestController
@RequestMapping("/hyxh")
public class TradeManageController {

    @Resource
    private TradeManageService service;

    /**
     * 行业协会数据查询接口（含件）
     *
     * @param request http请求
     * @param type    查询类型（协会培训等）
     * @param date    日期
     * @param tp      查询数据类型（施工员等）
     * @param keyWord 关键字
     * @param page    页码
     * @return 响应结果
     */
    @RequestMapping("/find/cont/{type}")
    public Object queryTradeController(HttpServletRequest request, @PathVariable("type") String type, String date, String tp, String keyWord, String page) {
        return this.service.queryTradeService(request, type, date, tp, keyWord, page);
    }

    /**
     * 行业协会数据查询接口（无文件）
     *
     * @param type    查询类型（协会培训等）
     * @param date    日期
     * @param tp      查询数据类型（施工员等）
     * @param comp    企业
     * @param year    年份
     * @param keyWord 关键字
     * @param page    页码
     * @param member  会员属性（0为会员）
     * @return 响应结果
     */
    @RequestMapping("/find/{type}")
    public Object queryTradeController(@PathVariable("type") String type, String date, String tp, String comp, String year, String keyWord, String page, String member) {
        return this.service.queryTradeService(type, date, tp, comp, year, keyWord, page, member);
    }

    /**
     * 会费数据添加接口
     *
     * @param msg 数据
     * @return 响应结果
     */
    @RequestMapping(value = "/add/hf", method = RequestMethod.POST)
    public Status addTradeController(Dues msg) {
        return this.service.addTradeService("hf", msg);
    }

    /**
     * 联系协会数据添加接口
     *
     * @param msg 数据
     * @return 响应结果
     */
    @RequestMapping(value = "/add/lxxh", method = RequestMethod.POST)
    public Status addTradeController(Contact msg) {
        return this.service.addTradeService("lxxh", msg);
    }

    /**
     * 动态资讯数据添加接口
     *
     * @param msg 数据
     * @return 响应结果
     */
    @RequestMapping(value = "/add/dtzx", method = RequestMethod.POST)
    public Status addTradeController(Information msg) {
        return this.service.addTradeService("dtzx", msg);
    }

    /**
     * 优质工程数据添加接口
     *
     * @param msg 数据
     * @return 响应结果
     */
    @RequestMapping(value = "/add/yzgc", method = RequestMethod.POST)
    public Status addQualEnginController(QualEngin msg) {
        return this.service.addTradeService("yzgc", msg);
    }


    /**
     * 协会培训数据添加接口
     *
     * @param files    上传文件
     * @param fileType 文件类型（文档/图片）
     * @param msg      数据
     * @return 响应结果
     */
    @RequestMapping(value = "/add/xhpx", method = RequestMethod.POST)
    public Status addController(@RequestParam("files") MultipartFile[] files, String fileType, TrainsInfo msg) {
        return this.service.addTradeService(files, fileType, "xhpx", msg);
    }

    /**
     * 删除行业协会数据接口（有文件）
     *
     * @param type 删除数据类型（如：删除协会培训数据等）
     * @param id   数据id（文件编号）
     * @return 响应结果
     */
    @RequestMapping("/delete/cont/{type}")
    public Status deleteTradeController(@PathVariable("type") String type, String[] id) {
        return this.service.deleteTradeService(type, id);
    }

    /**
     * 删除行业协会数据接口（无文件）
     *
     * @param type 删除数据类型（如：删除会费数据等）
     * @param id   数据id（文件编号）
     * @return 响应结果
     */
    @RequestMapping("/delete/{type}")
    public Status deleteTradeController(@PathVariable("type") String type, int[] id) {
        return this.service.deleteTradeService(type, id);
    }
}
