package com.dianping.hui.controller;

import com.dianping.hui.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    private static final String APP_KEY_MICRO_PROVIDER_USER = "provider-user";

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        /**
         * localhost:8000访问不了，需要用provider-user无端口替换替换。
         * 原因是当Ribbon和Eurake配合使用的时候，会自动将虚拟主机名映射成微服务的网络地址。
         */
        return restTemplate.getForObject(userServiceUrl + "/user/" + id, User.class);
    }

    /**
     * 服务中心的user服务的info
     * @return
     */
    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        return discoveryClient.getInstances(APP_KEY_MICRO_PROVIDER_USER);
    }
    /**
     * 打印当前选择的是哪个节点
     */
    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance instance = loadBalancerClient.choose(APP_KEY_MICRO_PROVIDER_USER);
        log.info("{}:{}:{}", instance.getServiceId(),instance.getHost(), instance.getPort());
    }

}
