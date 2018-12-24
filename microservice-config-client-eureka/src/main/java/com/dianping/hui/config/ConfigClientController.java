package com.dianping.hui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lanxinyu@meituan.com  2018-12-04 9:36 PM
 * @Description:
 */
@RestController
public class ConfigClientController {

    @Value("${profile}")
    private String profile;
    @Value("${whoami}")
    private String whoami;
    @Value("${config.server}")
    private String configServer;

    @GetMapping("/profile")
    public String profile() {
        return profile;
    }

    @GetMapping("/whoami")
    public String whoami() {
        return whoami;
    }
}
