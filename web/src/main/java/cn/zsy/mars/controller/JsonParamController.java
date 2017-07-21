package cn.zsy.mars.controller;

import cn.zsy.mars.entity.EmResult;
import com.alibaba.fastjson.JSONObject;
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


    @ResponseBody
    @RequestMapping("/resquestbean")
    public EmResult testRequestBodyForBean(@RequestBody String blog) throws Exception {
        EmResult emResult = new EmResult();
        System.out.println("=================" + blog);
        logger.info(blog.toString());
        emResult.setRetCode("123");
        emResult.setRetInfo("success");
        emResult.setData(JSONObject.parseObject(blog));
        logger.info(emResult.toString());
        return emResult;
    }

}
