package com.zyc.springbootdatasource.service;

import com.zyc.springbootdatasource.entity.User;
import com.zyc.springbootdatasource.mapperMaster.UserMapperMaster;
import com.zyc.springbootdatasource.mapperSlaver.UserMapperSlaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月21日 14:44
 * @desc DataSourceService
 */
@Service
public class DataSourceService {

    @Autowired
    UserMapperMaster master;

    @Autowired
    UserMapperSlaver slaver;

    public User getUserToMaster(String name){
        return master.getUser(name);
    }

    public User getUserToSlaver(String name){
        return slaver.getUser(name);
    }
}
