package com.zyc.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月22日 18:38
 * @desc ProviderServiceImpl
 */
@Component
@Service
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String getMsg() {
        return "这是提供者的消息";
    }
}
