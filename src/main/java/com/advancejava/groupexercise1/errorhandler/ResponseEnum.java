package com.advancejava.groupexercise1.errorhandler;

public enum ResponseEnum {

    INSUFFIENT_BALANCE(ResponseCodes.INSUFFICIENT_AMOUNT
            , "Insufficient Balance."),
    ACCOUNT_NOT_FOUND(ResponseCodes.ACCOUNT_NOT_FOUND
            , "Account Not Found.");

    private String errorCode;
    private String errorMessage;

    ResponseEnum(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
