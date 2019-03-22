package com.zyc.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zyc.provider.service.ProviderService;
import org.springframework.stereotype.Service;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月22日 19:19
 * @desc ConsumerService
 */
@Service
public class ConsumerService {

    @Reference
    ProviderService service;

    public void print(){
        String msg = service.getMsg();
        System.out.println("收到:"+msg);
    }
}
