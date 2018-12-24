package com.dianping.hui.api;

import com.dianping.hui.entity.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: lanxinyu@meituan.com  2018-11-19 下午3:27
 * @Description:
 */
@Slf4j
@Component
public class FeignClientFallbackFactory implements FallbackFactory<UseFeignClient> {

    @Override
    public UseFeignClient create(final Throwable throwable) {
        return new UseFeignClient() {
            @Override
            public User findById(Long id) {
                log.error("fallback UseFeignClient.findById: {}", throwable);
                User user = new User();
                user.setId(id);
                user.setName("默认用户");
                return user;
            }
        };
    }
}
