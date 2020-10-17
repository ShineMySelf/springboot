package com.demo.constant;

public enum  ResponseCode {

    SUCCESS(200),FAIL(500);
    private int code;
    private ResponseCode(int code){
        this.code = code;
    }

    /**
     * 获取状态
     * @return
     */
    public int getCode(){
        return this.code;
    }
}
