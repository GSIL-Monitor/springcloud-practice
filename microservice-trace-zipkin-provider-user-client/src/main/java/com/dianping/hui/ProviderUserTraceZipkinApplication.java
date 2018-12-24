package com.dianping.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: lanxinyu@meituan.com  2018-12-09 1:25 PM
 * @Description: Spring Cloud Sleuth 与 Zipkin配合使用 p200
 */
@SpringBootApplication
public class ProviderUserTraceZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUserTraceZipkinApplication.class, args);
    }
}
