package cn.zsy.mars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/monitor/jvm")
public class JvmMonitorController {

    @RequestMapping("")
    public String index() {
//        return viewName("index");
        return "jsp/admin/monitor/jvm/index";
    }


}
