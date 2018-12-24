package com.dianping.hui.api;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author: lanxinyu@meituan.com  2018-11-19 下午3:48
 * @Description: Feign 禁用 Hystrix
 * 全局禁用 Hystrix ： feign.hystrix.enabled=false
 */

@Configuration
public class FeignDisableHystrixConfiguration {

    @Scope("prototype")
    @Bean public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
