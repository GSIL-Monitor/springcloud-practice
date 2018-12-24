package com.dianping.hui.controller;

import com.dianping.hui.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: lanxinyu@meituan.com  2018-11-06 下午8:20
 * @Description:
 */
@RestController
@Slf4j
public class MovieController {
    @Value("${user.service.url}")
    private String userServiceUrl;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
            @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value = "10000")
    }, threadPoolProperties = {
            @HystrixProperty(name="coreSize", value = "1"),
            @HystrixProperty(name="maxQueueSize", value = "10")
    }, ignoreExceptions = {
            IllegalStateException.class
    })
    public User findById(@PathVariable Long id) {
        /**
         * localhost:8000访问不了，需要用provider-user无端口替换替换。
         * 原因是当Ribbon和Eurake配合使用的时候，会自动将虚拟主机名映射成微服务的网络地址。
         */

        return restTemplate.getForObject(userServiceUrl + "/user/" + id, User.class);
    }

    public User findByIdFallback(Long id, Throwable t) {
        log.error("findByIdFallback reason:", t);
        User user = new User();
        user.setId(id);
        user.setName("默认用户");
        return user;
    }


}
