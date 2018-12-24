package com.dianping.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

/**
 * @author: lanxinyu@meituan.com  2018-12-04 2:06 PM
 * @Description: 使用Zuul聚合微服务
 */
@SpringBootApplication
@EnableZuulProxy
@PropertySource("classpath:config.properties")
public class ZuulApplication {
    @LoadBalanced
    @Bean public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
