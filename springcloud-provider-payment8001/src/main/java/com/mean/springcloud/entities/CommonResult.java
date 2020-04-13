package com.mean.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/13
 *  Time: 20:58
 *  Description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>
{
    private Integer code;
    private String  message;
    private T       Data;

    public CommonResult(Integer code,String message)
    {
        this(code,message,null);
    }
}
