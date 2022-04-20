package com.example.homework.common;

import lombok.Data;

import java.util.Map;

@Data
public class R<T> {
    private Integer code; // 1是成功 0失败

    private String msg; // 错误信息

    private T data; // 数据，传一个对象

    private Map map; // 动态数据

    public static <T> R<T> success(T object){
        R<T> r = new R<>();
        r.code = 1;
        r.data = object;
        return r;
    }

    public static <T> R<T> error(String msg){
        R<T> r = new R<>();
        r.code = 0;
        r.msg = msg;
        return r;
    }

}
