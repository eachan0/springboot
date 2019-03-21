package com.zyc.springbootdatasource.mapperMaster;

import com.zyc.springbootdatasource.entity.User;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月21日 14:11
 * @desc UserMapper
 */
public interface UserMapperMaster{
    User getUser(String name);
}
