package com.zyc.springbootelasticsearch.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月22日 16:09
 * @desc User
 */
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "test",type = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 2453663001897332885L;

    private Integer id;
    private String name;
    private String age;
}
