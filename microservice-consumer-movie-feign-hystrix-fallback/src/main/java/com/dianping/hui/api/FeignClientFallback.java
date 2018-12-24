package com.dianping.hui.api;

import com.dianping.hui.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author: lanxinyu@meituan.com  2018-11-19 下午2:39
 * @Description: hystrix 回退
 */
@Component
public class FeignClientFallback implements UseFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("默认用户");
        return user;
    }
}
