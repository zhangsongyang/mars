package cn.zsy.mars.controller;

import cn.zsy.mars.service.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
public class HelloWord {

    private static final Logger logger = LoggerFactory.getLogger(HelloWord.class);

    @Autowired
    private BaseService baseService;

    /**
     * 1. 使用 @RequestMapping 注解来映射请求的 URL
     * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于 InternalResourceViewResolver 视图解析器, 会做如下的解析:
     * 通过 prefix + returnVal + 后缀 这样的方式得到实际的物理视图, 然会做转发操作
     * <p>
     * /WEB-INF/views/success.jsp
     *
     * @return
     */
    @RequestMapping("/helloword")
    public String hello() {
        baseService.saveService();
        System.out.println("hello word!");
        return "success";
    }

    public static void main(String[] args) {

        File file = new File("c:/a/b.txt");
        System.out.println(StringUtils.indexOf("/asdf/group1/M00/00/1F/wKjUnVe4Ew-IQ0FBAAAdI87wwTkAAAKrggUg30AAB07719.jpg", "/group1", 0) == 0);
    }

}
