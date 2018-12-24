package com.dianping.hui;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author: lanxinyu@meituan.com  2018-11-12 下午8:56
 * @Description:
 */

/**
 * 这种方式，或者
 */
//@Configuration
public class FeignLogConfiguration {
    @Bean
    public Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }
}
