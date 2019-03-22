package com.zyc.springbootelasticsearch.repository;

import com.zyc.springbootelasticsearch.bean.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月22日 15:59
 * @desc BookRepository
 */
public interface UserRepository extends ElasticsearchRepository<User,Integer> {
    List<User> findByNameLike(String name);
}
