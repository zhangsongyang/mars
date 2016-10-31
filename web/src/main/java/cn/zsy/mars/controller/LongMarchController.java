package cn.zsy.mars.controller;

import cn.zsy.mars.entity.LongMarchEntity;
import cn.zsy.mars.service.LongMarchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/longmarch")
public class LongMarchController {

    private static final String SUCCESS = "success";

    private static final Logger logger = LoggerFactory.getLogger(LongMarchController.class);

    @Autowired
    private LongMarchService longMarchService;


    @RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    public String testCount() throws Exception {
        int conunt = longMarchService.count();
        logger.info("count: {}", conunt);
        return SUCCESS;
    }


    @RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
    public String testQuery() throws Exception {
        LongMarchEntity longMarchEntity = new LongMarchEntity();
        longMarchEntity.setAreaAbb("cs");
        List<LongMarchEntity> longMarchEntityList = longMarchService.query(longMarchEntity);
        for(LongMarchEntity longMarchEntity1 : longMarchEntityList){
            logger.info("Query: {}", longMarchEntity1.toString());
        }
        return SUCCESS;
    }


    @RequestMapping(value = "/insert", method = {RequestMethod.GET, RequestMethod.POST})
    public String testInsert() throws Exception {
        LongMarchEntity longMarchEntity = new LongMarchEntity();
        longMarchEntity.setUserType(2);
        longMarchEntity.setAreaAbb("cs");
        longMarchEntity.setContent("你会挽着我的衣袖,我会把手揣进裤兜.");
        longMarchEntity.setCreateTime(new Date());
        longMarchEntity.setUserId(10000);
        int id = longMarchService.insertMySQL(longMarchEntity);
        logger.info("Insert: {}", longMarchEntity.getId());
        return SUCCESS;
    }


    @RequestMapping(value = "/update/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String testUpdate(@PathVariable Integer id) throws Exception {
        LongMarchEntity longMarchEntity = new LongMarchEntity();
        longMarchEntity.setId(id);
        longMarchEntity.setUserType(1);
        longMarchEntity.setAreaAbb("cs");
        longMarchEntity.setContent("你会挽着我的衣袖,我会把手揣进裤兜.");
        longMarchEntity.setCreateTime(new Date());
        longMarchEntity.setUserId(11000);
        longMarchService.update(longMarchEntity);
        logger.info("update: {}", longMarchEntity.toString());
        return SUCCESS;
    }


    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String testDelete(@PathVariable Long id) throws Exception {
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);
        logger.info("delete before: {}", longMarchService.count());
        longMarchService.delete(ids);
        logger.info("delete after: {}", longMarchService.count());
        return SUCCESS;
    }


    @RequestMapping(value = "/querypage", method = {RequestMethod.GET, RequestMethod.POST})
    public String testQueryPage() throws Exception {
        LongMarchEntity longMarchEntity = new LongMarchEntity();
        longMarchEntity.setAreaAbb("cs");
        List<LongMarchEntity> longMarchEntityList = longMarchService.queryPage(longMarchEntity);
        for (LongMarchEntity longMarchEntity1 : longMarchEntityList) {
            logger.info("QueryPage: {}", longMarchEntity1.toString());
        }
        return SUCCESS;
    }

}
