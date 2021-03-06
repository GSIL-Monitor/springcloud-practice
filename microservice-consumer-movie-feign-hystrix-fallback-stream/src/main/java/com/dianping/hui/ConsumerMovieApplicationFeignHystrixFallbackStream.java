package com.dianping.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author: lanxinyu@meituan.com  2018-11-06 下午8:18
 * @Description:
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class ConsumerMovieApplicationFeignHystrixFallbackStream {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieApplicationFeignHystrixFallbackStream.class, args);
    }
}
