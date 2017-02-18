package cn.zsy.mars.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class JsonParamController {

    private static final Logger logger = LoggerFactory.getLogger(JsonParamController.class);

    @ResponseBody
    @RequestMapping("/resquest")
    public String testRequestBody(@RequestBody String blog) throws Exception {
        System.out.println("=================" + blog);
        logger.info(blog.toString());
        return blog.toString();
    }

}
