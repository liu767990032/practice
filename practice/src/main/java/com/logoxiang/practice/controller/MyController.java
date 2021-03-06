package com.logoxiang.practice.controller;

import com.alibaba.fastjson.JSON;
import com.logoxiang.practice.dao.MyDao;
import com.logoxiang.practice.util.NetUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @Author: liuXiang
 * @Date: 2020/4/24 16:58
 */
@RestController
public class MyController {
    @Autowired
    private MyDao myDao;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(MyController.class);

    @GetMapping("getCommonQuestionList")
    public List<Map<String, Object>> getCommonQuestionList() {
        //777
        List<Map<String, Object>> commonQuestionList = myDao.getCommonQuestionList();
        //8888
        logger.info("获取问题信息列表："+ JSON.toJSONString(commonQuestionList));
        //9999
        return commonQuestionList;
    }

    @GetMapping("getCommonQuestionList2")
    public List<Map<String, Object>> getCommonQuestionList2() {
        List<Map<String, Object>> commonQuestionList = myDao.getCommonQuestionList2();
        logger.info("获取问题信息列表："+ JSON.toJSONString(commonQuestionList));
        return commonQuestionList;
    }

    @GetMapping("getWeather")
    public String getWeatherData(){
        //54321
        NetUtils.Result result = NetUtils.get("http://t.weather.sojson.com/api/weather/city/101030100", null, "UTF-8");
       //******
        logger.info("天气结果"+result.getRespString());
        return result.getRespString();
    }

    @GetMapping("getWeather2")
    public Map getWeatherData2(){
        Map forEntity = restTemplate.getForObject("http://t.weather.sojson.com/api/weather/city/101030100", Map.class);
        logger.info(forEntity.toString());
        //112321
        return forEntity;
    }

}
