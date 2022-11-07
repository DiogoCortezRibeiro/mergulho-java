package com.algaloapi.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Data
@Embeddable // indicamos que esta classe pode ser usada como embededd para outra classe
public class Destinatario {

    @Column(name = "destinatario_nome")
    @NotBlank
    private String nome;

    @Column(name = "destinatario_logradouro")
    @NotBlank
    private String logradouro;

    @Column(name = "destinatario_numero")
    @NotBlank
    private String numero;

    @Column(name = "destinatario_complemento")
    @NotBlank
    private String complemento;

    @Column(name = "destinatario_bairro")
    @NotBlank
    private String bairro;
}
