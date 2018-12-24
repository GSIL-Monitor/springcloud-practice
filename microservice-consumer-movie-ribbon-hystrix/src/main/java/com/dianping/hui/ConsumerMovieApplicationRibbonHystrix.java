package com.dianping.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

/**
 * @author: lanxinyu@meituan.com  2018-11-06 下午8:18
 * @Description:
 */

/**
 * RibbonClient 可自定义指定名称Ribbon客户端（"provider-user"）配置
 *
 * 也可用RibbonClients为所有Ribbon客户端统一配置
 *
 * 亦可以通过properties配置实现
 */
@SpringBootApplication
@PropertySource("classpath:constant.properties")
/**
 * EnableHystrix 开启断路器支持 或使用 {@link org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker}
 */
@EnableHystrix
public class ConsumerMovieApplicationRibbonHystrix {

    /**
     * 为restTemple整合ribbon，使其具备负载均衡的能力
     */
    @LoadBalanced
    @Bean public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieApplicationRibbonHystrix.class, args);
    }
}