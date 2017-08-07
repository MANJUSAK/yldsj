package com.goodsoft.yuanlin.controller;

import com.goodsoft.yuanlin.entity.Bid;
import com.goodsoft.yuanlin.entity.Equipment;
import com.goodsoft.yuanlin.entity.Recruit;
import com.goodsoft.yuanlin.entity.Seedling;
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
     * @param type 查询什么的数据（招标，苗木等），
     *             request http请求（用以文件展示），
     *             uid 用户编号，
     *             date 发布日期，
     *             breed 苗木品种，
     *             tp 人员招聘类型（招聘 1/求职 2），
     *             cts 招聘性质（全职 1/兼职 2），
     *             sub 苗木品种二级类型,
     *             page 页码。
     * @return 查询结果
     */
    @RequestMapping("/{type}")
    public Object queryDemandReleaseController(@PathVariable("type") String type, String uid, HttpServletRequest request, String date, String breed, String tp, String cts, String sub, int page) {
        return this.service.queryReleaseData(uid, type, request, date, breed, tp, cts, sub, page);
    }

    /**
     * 设备租赁发布数据接口
     *
     * @param files 查询什么的数据（招标，苗木等），
     *              request http请求（用以文件保存），
     *              msg 设备租赁数据，
     *              type 发布类型（苗木、设备租赁等），
     * @return 发布结果
     */
    @RequestMapping(value = "/release/equipment", method = RequestMethod.POST)
    public Status saveEquipmentController(@RequestParam("files") MultipartFile[] files, Equipment msg, HttpServletRequest request) {
        return this.service.releaseDataService(files, request, msg, "equipment");
    }

    /**
     * 苗木信息发布数据接口
     *
     * @param files 查询什么的数据（招标，苗木等），
     *              request http请求（用以文件保存），
     *              msg 设备租赁数据，
     *              type 发布类型（苗木、设备租赁等），
     * @return 发布结果
     */
    @RequestMapping(value = "/release/seedling", method = RequestMethod.POST)
    public Status saveSeedlingController(@RequestParam("files") MultipartFile[] files, HttpServletRequest request, Seedling msg) {
        return this.service.releaseDataService(files, request, msg, "seedling");
    }

    /**
     * 人员招聘发布数据接口
     *
     * @param msg 设备租赁数据，
     *            type 发布类型（苗木、设备租赁等），
     * @return 发布结果
     */
    @RequestMapping(value = "/release/recruit", method = RequestMethod.POST)
    public Status saveRecruitController(Recruit msg) {
        return this.service.releaseDataService(msg, "recruit");
    }

    /**
     * 招标信息发布数据接口
     *
     * @param msg 设备租赁数据，
     *            type 发布类型（苗木、设备租赁等），
     * @return 发布结果
     */
    @RequestMapping(value = "/release/bid", method = RequestMethod.POST)
    public Status saveBidController(Bid msg) {
        return this.service.releaseDataService(msg, "bid");
    }

}
