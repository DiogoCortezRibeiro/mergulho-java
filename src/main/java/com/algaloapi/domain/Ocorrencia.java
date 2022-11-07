package com.algaloapi.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@Entity
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Entrega entrega;

    private String descricao;
    private OffsetDateTime dataRegistro;
}
