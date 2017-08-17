package com.goodsoft.yuanlin.controller;

import com.goodsoft.yuanlin.domain.entity.project.*;
import com.goodsoft.yuanlin.service.ProjectManageService;
import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * function 项目管理访问接口
 * Created by 严彬荣 on 2017/8/15.
 */
@RestController
@RequestMapping("/project")
public class ProjectManageController {
    @Resource
    private ProjectManageService service;

    @RequestMapping("/find/{type}")
    public Object qureyProjectDataController(HttpServletRequest request, String deptId, String uid, @PathVariable("type") String type, String page) {
        return this.service.queryProjectDataService(request, deptId, uid, type, page);
    }

    @RequestMapping(value = "/add/bggl", method = RequestMethod.POST)
    public Status addProjectDataController(HttpServletRequest request, @RequestParam("files") MultipartFile[] files, Alteration msg) {
        return this.service.addProjectDataService(request, files, msg, "bggl");
    }

    @RequestMapping(value = "/add/gxby", method = RequestMethod.POST)
    public Status addProjectDataController(HttpServletRequest request, @RequestParam("files") MultipartFile[] files, Checkout msg) {
        return this.service.addProjectDataService(request, files, msg, "gxby");
    }

    @RequestMapping(value = "/add/sgrz", method = RequestMethod.POST)
    public Status addProjectDataController(ConsLog msg) {
        return this.service.addProjectDataService(msg, "sgrz");
    }

    @RequestMapping(value = "/add/sgaqrz", method = RequestMethod.POST)
    public Status addProjectDataController(ConsSafetyLog msg) {
        return this.service.addProjectDataService(msg, "sgaqrz");
    }

    @RequestMapping(value = "/add/jdsb", method = RequestMethod.POST)
    public Status addProjectDataController(HttpServletRequest request, @RequestParam("files") MultipartFile[] files, Declaration msg) {
        return this.service.addProjectDataService(request, files, msg, "jdsb");
    }

    @RequestMapping(value = "/add/sbxx", method = RequestMethod.POST)
    public Status addProjectDataController(Equipment msg) {
        return this.service.addProjectDataService(msg, "sbxx");
    }

    @RequestMapping(value = "/add/jgys", method = RequestMethod.POST)
    public Status addProjectDataController(HttpServletRequest request, @RequestParam("files") MultipartFile[] files, Finalaccept msg) {
        return this.service.addProjectDataService(request, files, msg, "jgys");
    }

    @RequestMapping(value = "/add/hsjg", method = RequestMethod.POST)
    public Status addProjectDataController(HttpServletRequest request, @RequestParam("files") MultipartFile[] files, HsResult msg) {
        return this.service.addProjectDataService(request, files, msg, "hsjg");
    }

    @RequestMapping(value = "/add/kgbg", method = RequestMethod.POST)
    public Status addProjectDataController(HttpServletRequest request, @RequestParam("files") MultipartFile[] files, KgReport msg) {
        return this.service.addProjectDataService(request, files, msg, "kgbg");
    }

    @RequestMapping(value = "/add/wdgj", method = RequestMethod.POST)
    public Status addProjectDataController(Mylocus msg) {
        return this.service.addProjectDataService(msg, "wdgj");
    }

    @RequestMapping(value = "/add/xmxx", method = RequestMethod.POST)
    public Status addProjectDataController(Project msg) {
        return this.service.addProjectDataService(msg, "xmxx");
    }

    @RequestMapping(value = "/add/xckc", method = RequestMethod.POST)
    public Status addProjectDataController(HttpServletRequest request, @RequestParam("files") MultipartFile[] files, Prospect msg) {
        return this.service.addProjectDataService(request, files, msg, "xckc");
    }

    @RequestMapping(value = "/add/xmjs", method = RequestMethod.POST)
    public Status addProjectDataController(HttpServletRequest request, @RequestParam("files") MultipartFile[] files, Settlement msg) {
        return this.service.addProjectDataService(request, files, msg, "xmjs");
    }

    @RequestMapping(value = "/add/sgry", method = RequestMethod.POST)
    public Status addProjectDataController(SgPersonnel msg) {
        return this.service.addProjectDataService(msg, "sgry");
    }

    @RequestMapping(value = "/add/sgqb", method = RequestMethod.POST)
    public Status addProjectDataController(SgWallet msg) {
        return this.service.addProjectDataService(msg, "sgqb");
    }

    @RequestMapping(value = "/add/jlrz", method = RequestMethod.POST)
    public Status addProjectDataController(Suplog msg) {
        return this.service.addProjectDataService(msg, "jlrz");
    }

    @RequestMapping(value = "/add/ghs", method = RequestMethod.POST)
    public Status addProjectDataController(HttpServletRequest request, @RequestParam("files") MultipartFile[] files, Supplier msg) {
        return this.service.addProjectDataService(request, files, msg, "ghs");
    }

    @RequestMapping(value = "/add/jsjd", method = RequestMethod.POST)
    public Status addProjectDataController(HttpServletRequest request, @RequestParam("files") MultipartFile[] files, Technology msg) {
        return this.service.addProjectDataService(request, files, msg, "jsjd");
    }


}
