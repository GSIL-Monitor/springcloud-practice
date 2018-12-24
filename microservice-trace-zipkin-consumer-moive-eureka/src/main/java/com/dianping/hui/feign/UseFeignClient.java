package com.dianping.hui.feign;

import com.dianping.hui.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: lanxinyu@meituan.com  2018-12-09 5:04 PM
 * @Description:
 */
@FeignClient(name="microservice-trace-zipkin-provider-user-eureka")
public interface UseFeignClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}