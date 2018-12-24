package com.dianping.hui.controller;

import com.dianping.hui.api.UseFeignClient;
import com.dianping.hui.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lanxinyu@meituan.com  2018-11-06 下午8:20
 * @Description:
 */
@RestController
public class MovieController {

    @Autowired
    private UseFeignClient useFeignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return useFeignClient.findById(id);
    }

}
