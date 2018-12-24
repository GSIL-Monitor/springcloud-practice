package com.dianping.hui.controller;

import com.dianping.hui.entity.User;
import com.dianping.hui.feign.UseFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: lanxinyu@meituan.com  2018-11-06 下午8:20
 * @Description:
 */
@RestController
public class MovieController {
    @Autowired
    UseFeignClient useFeignClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return useFeignClient.findById(id);
    }

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        return discoveryClient.getInstances("provider-user");
    }
}
