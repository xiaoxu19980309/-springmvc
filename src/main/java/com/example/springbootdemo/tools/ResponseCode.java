package com.example.springbootdemo.tools;

public enum ResponseCode {
    SUCCESS("200","成功"),
    ERROR("500","操作失败");

    private ResponseCode(String value,String msg){
        this.val = value;
        this.msg = msg;
    }
    public String val(){
        return val;
    }
    public String msg(){
        return msg;
    }
    private String val;
    private String msg;
}
