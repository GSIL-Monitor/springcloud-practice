package com.dianping.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

/**
 * @author: lanxinyu@meituan.com  2018-11-06 下午8:18
 * @Description:
 */
@SpringBootApplication
@PropertySource("classpath:constant.properties")
public class ConsumerMovieTraceZipkinApplication {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieTraceZipkinApplication.class, args);
    }
}
