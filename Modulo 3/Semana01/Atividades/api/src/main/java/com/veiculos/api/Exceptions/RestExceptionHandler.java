package com.veiculos.api.Exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RegistroExistenteException.class)
    public ResponseEntity<Object> handleRegistroExistenteException(RegistroExistenteException e) {
        Map<String, String> retorno = new HashMap<>();
        retorno.put("erro", "Registro já cadastrado!");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(retorno);
    }

    @ExceptionHandler(RegistroNaoEncontradoException.class)
    public ResponseEntity<Object> handleRegistroNaoEncontradoException(RegistroNaoEncontradoException e) {
        Map<String, String> retorno = new HashMap<>();
        retorno.put("erro", "Registro não encontrado!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(retorno);
    }

    @ExceptionHandler(VeiculoComMultasException.class)
    public ResponseEntity<Object> handleFalhaExclusaoVeiculoComMultasException(VeiculoComMultasException e) {
        Map<String, String> retorno = new HashMap<>();
        retorno.put("erro", "Veículo possui multas e não pode ser excluído!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(retorno);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            fieldErrors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrors);
    }


    @Override   // catch any other exception for standard error message handling
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        Map<String, String> retorno = new HashMap<>();
        retorno.put("erro", "Erro no servidor! Contate o administrador do sistema!");
        return new ResponseEntity<>(retorno, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}