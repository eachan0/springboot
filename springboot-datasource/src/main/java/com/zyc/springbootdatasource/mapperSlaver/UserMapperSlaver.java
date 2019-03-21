package com.zyc.springbootdatasource.mapperSlaver;

import com.zyc.springbootdatasource.entity.User;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月21日 14:11
 * @desc UserMapper
 */
public interface UserMapperSlaver{
    User getUser(String name);
}
