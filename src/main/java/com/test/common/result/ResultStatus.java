package com.test.common.result;

/**
 * 状态码
 *
 * @author wangban
 * @date 9:58 2019/3/7
 */
public enum ResultStatus {
    /**
     * 成功
     */
    OK(200, "SUCCESS"),

    /**
     * 失败
     */
    ERROR(500, "ERROR"),

    /**
     * 无权限
     */
    NO_AUTH(500, "NO AUTH");
    private Integer code;

    private String message;

    ResultStatus(Integer code, String message) {
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
}
