package com.test.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author wangban
 * @date 9:57 2019/3/7
 */ 
@ApiModel("结果")
public class ResultJson<T> {

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("状态信息")
    private String message;

    @ApiModelProperty("数据")
    private T data;

    public ResultJson() {
    }

    private ResultJson(int code) {
        this.code = code;
    }

    private ResultJson(int code, T data) {
        this.code = code;
        this.data = data;
    }

    private ResultJson(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private ResultJson(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setStatus(ResultStatus code) {
        this.code = code.getCode();
        this.message = code.getMessage();
    }

    //正确信息
    public static <T> ResultJson<T> createBySuccess() {
        return new ResultJson<T>(ResultStatus.OK.getCode(), ResultStatus.OK.getMessage());
    }

    public static <T> ResultJson<T> createBySuccessMsg(String msg) {
        return new ResultJson<T>(ResultStatus.OK.getCode(), msg);
    }

    public static <T> ResultJson<T> createBySuccess(T data) {
        return new ResultJson<T>(ResultStatus.OK.getCode(), ResultStatus.OK.getMessage(), data);
    }

    public static <T> ResultJson<T> createBySuccess(String msg, T data) {
        return new ResultJson<T>(ResultStatus.OK.getCode(), msg, data);
    }

    //错误信息
    public static <T> ResultJson<T> createByError() {
        return new ResultJson<T>(ResultStatus.ERROR.getCode(), ResultStatus.ERROR.getMessage());
    }

    public static <T> ResultJson<T> createByErrorMsg(String errorMsg) {
        return new ResultJson<T>(ResultStatus.ERROR.getCode(), errorMsg);
    }


    public static <T> ResultJson<T> createByErrorCodeMsg(int errorCode, String errorMsg) {
        return new ResultJson<T>(errorCode, errorMsg);
    }

    public static <T> ResultJson<T> createByNoAuth() {
        return new ResultJson<T>(ResultStatus.NO_AUTH.getCode(), ResultStatus.NO_AUTH.getMessage());
    }


    @Override
    public String toString() {
        return "ResultJson{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
