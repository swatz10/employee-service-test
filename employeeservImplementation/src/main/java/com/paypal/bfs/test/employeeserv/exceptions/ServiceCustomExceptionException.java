package com.paypal.bfs.test.employeeserv.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ServiceCustomExceptionException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;

    public ServiceCustomExceptionException(String message, HttpStatus httpStatus) {
        super(message);
        this.message=message;
        this.httpStatus = httpStatus;
    }
}
