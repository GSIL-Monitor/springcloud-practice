package com.dianping.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * @author: lanxinyu@meituan.com  2018-12-09 3:58 PM
 * @Description: Spring Cloud Sleuth 与 Zipkin配合使用 p200
 */
@SpringBootApplication
@EnableZipkinServer
public class TraceZipkinServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TraceZipkinServerApplication.class, args);
    }
}
