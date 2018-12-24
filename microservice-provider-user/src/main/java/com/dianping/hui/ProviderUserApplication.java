package com.dianping.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: lanxinyu@meituan.com  2018-11-06 下午5:29
 * @Description:
 */

/**
 * SpringBootApplication是一个组合注解，他整合了@Configuration、@EnableAutoConfiguration 和 @ComponentScan
 * 并开启了Spring Boot程序的组件扫描和自动配置功能。
 */
@SpringBootApplication
public class ProviderUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUserApplication.class, args);
    }
}
