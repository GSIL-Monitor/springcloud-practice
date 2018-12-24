package com.dianping.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: lanxinyu@meituan.com  2018-11-21 2:22 PM
 * @Description: 服务网关  用途：p126
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    /**
     * 正则表达式指定 Zuul的路由匹配规则
     * @return
     */
    /*@Bean
    public PatternServiceRouteMapper patternServiceRouteMapper() {
        return new PatternServiceRouteMapper();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
