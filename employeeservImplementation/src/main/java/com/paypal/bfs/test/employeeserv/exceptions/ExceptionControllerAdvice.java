package com.paypal.bfs.test.employeeserv.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceCustomExceptionException.class)
    @NotNull
    public final ResponseEntity<ErrorInfo> handleServiceCustomException(@NotNull ServiceCustomExceptionException serviceCustomExceptionException,
                                                                        @NotNull WebRequest request) {
        return new ResponseEntity<>(new ErrorInfo(serviceCustomExceptionException.getHttpStatus().name(), serviceCustomExceptionException.getMessage()), serviceCustomExceptionException.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        List<String> errorList = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        String errorMessage = String.join(",", errorList);
        return new ResponseEntity<>(new ErrorInfo(HttpStatus.BAD_REQUEST.name(), errorMessage), HttpStatus.BAD_REQUEST);
    }
}
