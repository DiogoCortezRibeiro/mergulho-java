package com.algaloapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Problema {

    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
    private List<Campo> campos;

    @Data
    @AllArgsConstructor
    public static class Campo {
        private String nome;
        private String mensagem;
    }

}
