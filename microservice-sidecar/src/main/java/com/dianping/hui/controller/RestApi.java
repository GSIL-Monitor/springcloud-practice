package com.dianping.hui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: lanxinyu@meituan.com  2018-12-04 1:44 PM
 * @Description:
 */
@RestController
public class RestApi {
    @Autowired
    RestTemplate restTemplate;

    /**
     * 使用Sidecar微服务的serviceId，即可调用非JVM微服务的接口。
     * @return
     */
    @GetMapping("/test")
    public String test() {
        return restTemplate.getForObject("http://microservice-sidecar-node-service/", String.class);
    }
}
