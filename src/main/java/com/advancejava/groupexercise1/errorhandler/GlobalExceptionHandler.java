package com.advancejava.groupexercise1.errorhandler;

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
}
