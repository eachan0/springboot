package com.zyc.springbootcache.service.impl;

import com.zyc.springbootcache.bean.User;
import com.zyc.springbootcache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月21日 22:39
 * @desc UserServiceImpl
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        log.info("查询");
        return new User(1,"lisi");
    }

    @Override
    public User putUser() {
        log.info("更新");
        return new User(1,"zhangsan");
    }

    @Override
    public int delUser() {
        log.info("删除");
        return 1;
    }
}
