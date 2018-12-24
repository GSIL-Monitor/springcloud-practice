package com.dianping.notautoscan.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

/**
 * @author: lanxinyu@meituan.com  2018-11-11 下午4:59
 * @Description:
 */
@RibbonClient("provider-user")
public class RibbonClientConfig {
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
