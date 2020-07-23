package com.zx.hellocar.bean;

public class Result<T> {
    public int code = -1;
    public String msg = "失败";
    public T data = null;
}
