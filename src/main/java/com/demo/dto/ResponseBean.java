package com.demo.dto;

import com.demo.constant.ResponseCode;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class ResponseBean<T> implements Serializable {

    private int status;
    private String msg;
    private T data;//可以指定泛型里面的内容，也可以不指定，而且里面的类型可以是多种，map,list,string

    //编写外部访问的Public方法,之前需要写一个枚举类
    //这样外部的显示的就是这几个值啦
    public int getStatus(){
        return status;
    }
    public String getMsg(){
        return msg;
    }
    public T getData(){
        return data;
    }
    //判断是否登陆成功
    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    //编写 私有 的构造方法，外部是不能new的
    // 开放供外部使用的Public方法
    private ResponseBean(int status){
        this.status=status;
    }
    private ResponseBean(int status, T data){
        this.status=status;
        this.data=data;
    }
    private ResponseBean(int status, String msg){
        this.status=status;
        this.msg=msg;
    }

    private ResponseBean(int status, String msg, T data){
        this.status=status;
        this.msg=msg;
        this.data=data;
    }
    //编写成功静态的方法供外部的调用
    public static <T> ResponseBean<T> createBySuccess(){
        return new ResponseBean<T>(ResponseCode.SUCCESS.getCode());
    }

    public static  <T> ResponseBean<T> createBySuccess(T data){
        return new ResponseBean<T>(ResponseCode.SUCCESS.getCode(),data);

    }
    public static <T> ResponseBean<T> createBySuccess(String msg,T data){
        return new ResponseBean<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    public static <T> ResponseBean<T> createBySuccessMessage(String msg){
        return new ResponseBean<T>(ResponseCode.SUCCESS.getCode(),msg);

    }
    //编写失败的方法
    public static <T> ResponseBean<T> createByError(){
        return new ResponseBean<T>(ResponseCode.FAIL.getCode(),"fail");
    }
    public static <T> ResponseBean<T> createByErrorMessage(String errorMessage) {
        return new ResponseBean<T>(ResponseCode.FAIL.getCode(),errorMessage);
    }
    public static <T> ResponseBean<T> createByErrorCodeMessage(int errCode,String errMsg){
        return new ResponseBean<T>(errCode,errMsg);
    }

}
