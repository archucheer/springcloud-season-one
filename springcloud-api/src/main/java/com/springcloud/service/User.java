package com.springcloud.service;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain=true)
public class User implements Serializable {

    private Integer id;

    private String lastname;

    private String email;

    private Integer gender;

    private Integer dId;

    private String dbSource;


}