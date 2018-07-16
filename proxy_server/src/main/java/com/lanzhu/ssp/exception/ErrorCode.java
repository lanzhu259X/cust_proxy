package com.lanzhu.ssp.exception;

import com.alibaba.fastjson.JSONObject;

public enum ErrorCode {

    USER_NOT_FOUND(1001, "获取用户失败"),
    USER_PHONE_EMPTY(1002, "用户手机号为空"),


    PARAM_ERROR(1000, "参数错误"),

    LOGIN_PASSWORD_INVALID(9997, "登录密码验证失败"),
    LOGIN_USERNAME_MISSING(9998, "登录名缺失"),
    SYS_ERROR(9999, "系统异常");

    private int errorCode;
    private String errorMessage;
    private ErrorDisplay errorDisplay;

    private ErrorCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDisplay = ErrorDisplay.NOTICE; //默认
    }

    private ErrorCode(int errorCode, String errorMessage, ErrorDisplay errorDisplay) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDisplay = errorDisplay; //默认
    }

    public String toString() {
        JSONObject json = new JSONObject();
        json.put("errorCode", this.errorCode);
        json.put("errorMessage", this.errorMessage);
        json.put("errorDisplay", this.errorDisplay);
        return json.toString();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorDisplay getErrorDisplay() {
        return errorDisplay;
    }

    public void setErrorDisplay(ErrorDisplay errorDisplay) {
        this.errorDisplay = errorDisplay;
    }
}
