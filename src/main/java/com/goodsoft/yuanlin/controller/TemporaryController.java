package com.goodsoft.yuanlin.controller;

import com.goodsoft.yuanlin.temporary.TemporaryService;
import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * function 法人库数据导入入口类
 * Created by 法人库 on 2017/9/28.
 */
@RestController
@RequestMapping("/corporation")
public class TemporaryController {
    @Resource
    private TemporaryService service;

    @RequestMapping(value = "/input/data/excel/corporation.action.do", method = RequestMethod.POST)
    public Status temporaryController(@RequestParam("files") MultipartFile[] files) {
        return this.service.temporaryService(files);
    }
}
