package com.dianping.noautoconfig;

/**
 * @author: lanxinyu@meituan.com  2018-11-12 下午7:37
 * @Description:
 */

import feign.Contract;
import org.springframework.context.annotation.Bean;

/**
 * 该类可以不写@Configuration，如果加了@Configuration注解，那么该类不能放在主应用程序上下文@ComponentScan所扫描的包中。
 */
public class FeignConfiguration {

    /**
     * 将契约改为feign原生的默认契约。这样就可以使用feign自带的注解了。
     * @return
     */
    @Bean public Contract feignContract() {
        return new feign.Contract.Default();
    }
}
