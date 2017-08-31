package com.goodsoft.yuanlin.controller;

import com.goodsoft.yuanlin.domain.entity.demand.Bid;
import com.goodsoft.yuanlin.domain.entity.demand.Equipment;
import com.goodsoft.yuanlin.domain.entity.demand.Recruit;
import com.goodsoft.yuanlin.domain.entity.demand.Seedling;
import com.goodsoft.yuanlin.service.DemandReleaseService;
import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * function 需求发布数据访问入口
 * Created by 严彬荣 on 2017/8/4.
 */
@RestController
@RequestMapping("/xqfb")
public class DemandReleaseController {
    @Resource
    private DemandReleaseService service;

    /**
     * 查询需求发布数据接口
     *
     * @param type    查询什么的数据（招标，苗木等），
     * @param request http请求（用以文件展示），
     * @param uid     用户编号，
     * @param keyWord 标题名称
     * @param date    发布日期，
     * @param breed   苗木品种，
     * @param tp      人员招聘类型（招聘 1/求职 2），
     * @param cts     招聘性质（全职 1/兼职 2），
     * @param sub     苗木品种二级类型,
     * @param page    页码。
     * @return 查询结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/find/{type}")
    public Object queryDemandReleaseController(@PathVariable("type") String type, String uid, String comp, HttpServletRequest request, String keyWord, String date, String breed, String tp, String cts, String sub, String page) {
        return this.service.queryReleaseData(keyWord, comp, uid, type, request, date, breed, tp, cts, sub, page);
    }

    /**
     * 发布设备租赁数据入口
     *
     * @param files 查询什么的数据（招标，苗木等），
     * @param msg   设备租赁数据，
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/release/equipment", method = RequestMethod.POST)
    public Status saveEquipmentController(@RequestParam("files") MultipartFile[] files, Equipment msg) {
        return this.service.releaseDataService(files, msg, "equipment");
    }

    /**
     * 发布苗木数据入口
     *
     * @param files 查询什么的数据（招标，苗木等），
     * @param msg   设备租赁数据，
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/release/seedling", method = RequestMethod.POST)
    public Status saveSeedlingController(@RequestParam("files") MultipartFile[] files, Seedling msg) {
        return this.service.releaseDataService(files, msg, "seedling");
    }


    /**
     * 发布招标数据接口
     *
     * @param msg 设备租赁数据，
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/release/bid", method = RequestMethod.POST)
    public Status saveBidController(Bid msg) {
        return this.service.releaseDataService(msg, "bid");
    }

    /**
     * 发布人员招聘数据入口
     *
     * @param msg 设备租赁数据，
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/release/recruit", method = RequestMethod.POST)
    public Status saveRecruitController(Recruit msg) {
        return this.service.releaseDataService(msg, "recruit");
    }


    /**
     * 删除需求发布数据访问入口
     *
     * @param id   数据id，
     * @param type 删除类型（苗木、设备租赁等），
     * @return 删除结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/delete/{type}", method = RequestMethod.POST)
    public Status deleteDemandReleaseController(@PathVariable("type") String type, int[] id) {
        return this.service.deleteReleaseDataService(id, type);
    }
}
