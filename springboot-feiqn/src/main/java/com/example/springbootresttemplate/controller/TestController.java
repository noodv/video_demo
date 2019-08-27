package com.example.springbootresttemplate.controller;

import com.example.springbootresttemplate.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @RequestMapping("test1")
    public void test1() {
        String response = restTemplate.getForObject("http://RESTTEMPLATE/test2",String.class);
        System.out.println(response);
    }

    @RequestMapping("test2")
    public String test2() {
        return "测试数据： test2";
    }

}
