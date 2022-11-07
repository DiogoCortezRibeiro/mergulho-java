package com.algaloapi.domain.dto;

import com.algaloapi.enums.StatusEntrega;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class EntregaDTO {

    private Long id;
    private String nomeCliente;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;
    private DestinatarioDTO destinatario;
    
}
