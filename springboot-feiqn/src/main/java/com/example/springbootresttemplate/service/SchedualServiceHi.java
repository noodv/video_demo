package com.example.springbootresttemplate.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-feign")   // 注意，这里要指定已有的服务名称,还有注意name和value的区别
public interface SchedualServiceHi {

    @RequestMapping(value = "test2", method = RequestMethod.GET)
    String sayHiFromClientOne();

}
