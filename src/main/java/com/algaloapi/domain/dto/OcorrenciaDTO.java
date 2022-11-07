package com.algaloapi.domain.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class OcorrenciaDTO {

    private Long id;
    private String descricao;
    private OffsetDateTime dataRegistro;
}
