package com.example.springbootdemo.tools;

import lombok.Data;

@Data
public class Result {
    private String resultCode;
    private String resultMsg;
    private Object data;

    public Result() {
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result success(Object data){
        return result(ResponseCode.SUCCESS.val(),ResponseCode.SUCCESS.msg(),data);
    }

    public static Result success(Object data,String msg){
        return result(ResponseCode.SUCCESS.val(),msg,data);
    }

    public static Result fail(String code,String msg){
        return result(code,msg,null);
    }

    public static Result fail(String code,String msg,Object data){
        return result(code,msg,data);
    }

    private static Result result(String val, String msg, Object data) {
        Result result = new Result();
        result.setResultCode(val);
        result.setResultMsg(msg);
        result.setData(data);
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultStatus=" + resultCode +
                ", resultMsg='" + resultMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
