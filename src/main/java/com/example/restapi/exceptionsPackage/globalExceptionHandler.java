package com.example.restapi.exceptionsPackage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class globalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<exceptionInfoDTO> restExceptionHandler(
            noSuchUserException e
    ){
        exceptionInfoDTO info = new exceptionInfoDTO();
        info.setInfo(e.getMessage());

        return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<exceptionInfoDTO> restIncorrectIdDataTypeExceptionHandler(
            MethodArgumentTypeMismatchException e
    ){
        exceptionInfoDTO info = new exceptionInfoDTO();
        info.setInfo(e.getMessage());

        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }
}
