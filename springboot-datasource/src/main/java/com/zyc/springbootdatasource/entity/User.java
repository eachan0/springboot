package com.zyc.springbootdatasource.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月21日 14:08
 * @desc User
 */
@Data
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 4188651804491483419L;

    private String username;

    private String password;
}
