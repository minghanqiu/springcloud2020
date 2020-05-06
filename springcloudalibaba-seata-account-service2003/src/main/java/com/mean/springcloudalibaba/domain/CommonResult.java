package com.mean.springcloudalibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/5/6
 *  Time: 22:47
 *  Description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T       data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}