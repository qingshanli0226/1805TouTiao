package com.example.framewrok.base.view;
public  class ErrorBean {
    public  String errorcode;
    private String errorMessage;
    public String getErrorCode() {
        return errorcode;
    }

    public void setErrorCode(String errorCode) {
        this.errorcode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}