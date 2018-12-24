package com.dianping.hui.repository;

import com.dianping.hui.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: lanxinyu@meituan.com  2018-12-09 11:19 AM
 * @Description:
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
