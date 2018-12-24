package com.dianping.hui.contoller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lanxinyu@meituan.com  2018-12-04 8:41 PM
 * @Description:
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${profile}")
    private String profile;
    @Value("${whoami}")
    private String whoami;

    @GetMapping("/profile")
    public String profile() {
        return profile;
    }

    @GetMapping("/whoami")
    public String whoami() {
        return whoami;
    }
}
