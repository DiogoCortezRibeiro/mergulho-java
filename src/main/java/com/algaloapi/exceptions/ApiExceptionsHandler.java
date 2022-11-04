package com.algaloapi.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice // a classe é um componente do spring porem para tratar exceções para controladores
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Problema problema = new Problema();
        problema.setCampos(buscaCamposComErro(ex));
        problema.setStatus(status.value());
        problema.setDataHora(LocalDateTime.now());
        problema.setTitulo("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente");

        return handleExceptionInternal(ex, problema, headers, status, request);
    }

    private List<Problema.Campo> buscaCamposComErro(MethodArgumentNotValidException ex) {
        List<Problema.Campo> campos = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String mensagem = error.getDefaultMessage();
            campos.add(new Problema.Campo(nome, mensagem));
        }

        return campos;
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Problema problema = new Problema();
        problema.setStatus(status.value());
        problema.setDataHora(LocalDateTime.now());
        problema.setTitulo("E-mail já cadastrado no sistema");

        return handleExceptionInternal(ex, problema,new HttpHeaders(), status, request);
    }
}
