package com.mean.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/13
 *  Time: 20:57
 *  Description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable
{
    private Long id;
    private String serial;
}
