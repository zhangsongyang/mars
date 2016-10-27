package cn.zsy.mars.controller;

import cn.zsy.mars.service.LongMarchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/longmarch")
public class LongMarchController {

    private static final String SUCCESS = "success";

    private static final Logger logger = LoggerFactory.getLogger(LongMarchController.class);

    @Autowired
    private LongMarchService longMarchService;


    @RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    public String testCount() throws Exception {
        logger.info("count: ");
        int conunt = longMarchService.count();
        logger.info(Integer.toString(conunt));
        return SUCCESS;
    }

}
