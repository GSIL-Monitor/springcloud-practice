package com.dianping.hui.controller;

import com.dianping.hui.entity.User;
import com.dianping.hui.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lanxinyu@meituan.com  2018-11-06 下午5:27
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return userRepository.findOne(id);
    }
}
