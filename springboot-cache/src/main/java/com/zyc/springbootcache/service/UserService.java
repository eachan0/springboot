package com.zyc.springbootcache.service;

import com.zyc.springbootcache.bean.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月21日 22:36
 * @desc UserService
 */
public interface UserService {

    @Cacheable(value = "users",key = "'user'")
    User getUser();

    @CachePut(value = "users",key = "'user'")
    User putUser();

    @CacheEvict(value = "users",key = "'user'")
    int delUser();
}
