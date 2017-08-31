package com.goodsoft.yuanlin.config.filter;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * function 资源不存在跳转
 * Created by 严彬荣 on 2017/8/24.
 */
@Controller
public class SystemError implements ErrorController {
    private static final String ERRORPAHT = "/error";

    @RequestMapping(value = ERRORPAHT)
    public String handleError() {
        return "redirect:/hint.html";
    }

    @Override
    public String getErrorPath() {
        return ERRORPAHT;
    }

}
