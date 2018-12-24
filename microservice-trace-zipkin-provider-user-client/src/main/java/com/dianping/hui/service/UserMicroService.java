package com.dianping.hui.service;

import com.dianping.hui.entity.User;
import com.dianping.hui.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lanxinyu@meituan.com  2018-12-09 1:27 PM
 * @Description:
 */
@RestController
public class UserMicroService {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getById(@PathVariable Long id) {
        return userRepository.findOne(id);
    }
}
