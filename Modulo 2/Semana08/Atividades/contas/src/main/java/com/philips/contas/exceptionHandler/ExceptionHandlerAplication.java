package com.philips.contas.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerAplication extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handlerException(Exception e){
        log.info("caiu no excpetion");
        return new ResponseEntity("error, não possível realizar a request solicitada", HttpStatus.BAD_GATEWAY);
    }
}
