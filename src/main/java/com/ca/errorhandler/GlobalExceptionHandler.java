package com.ca.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InsuffientBalanceException.class)
    protected ResponseEntity<ErrorResponseBody> handleInsuffientBalance() {
        ErrorResponseBody responseBody = new ErrorResponseBody();
        responseBody.setResponseCode(ResponseEnum.INSUFFIENT_BALANCE.getErrorCode());
        responseBody.setResponseMessage(ResponseEnum.INSUFFIENT_BALANCE.getErrorMessage());

        return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(AccountNotFoundException.class)
    protected ResponseEntity<ErrorResponseBody> handleAccountNotFound() {
        ErrorResponseBody responseBody = new ErrorResponseBody();
        responseBody.setResponseCode(ResponseEnum.ACCOUNT_NOT_FOUND.getErrorCode());
        responseBody.setResponseMessage(ResponseEnum.ACCOUNT_NOT_FOUND.getErrorMessage());

        return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
