package com.zyc.springbootelasticsearch.bean;

import io.searchbox.annotations.JestId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月22日 15:25
 * @desc Book
 */
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    private static final long serialVersionUID = 5353783861941238598L;

    @JestId
    private String id;
    private String name;
    private String antor;
}
