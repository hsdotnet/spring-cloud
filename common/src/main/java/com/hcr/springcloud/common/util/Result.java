package com.hcr.springcloud.common.util;

public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public Result() {

    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result instance(int code, String msg) {
        return new Result(code, msg);
    }

    public static Result success() {
        return new Result(0, "");
    }

    public static Result success(Object data) {
        return new Result(0, "", data);
    }

    public static Result error(String msg) {
        return new Result(-1, msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
