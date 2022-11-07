package com.algaloapi.domain;

import com.algaloapi.enums.StatusEntrega;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // vai vincular na tabela com base no cliente_id criado na tabela
    @NotNull
    @ConvertGroup(from = Builder.Default.class , to = ValidationGroups.ClienteId.class)
    @Valid
    private Cliente cliente;

    @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
    private List<Ocorrencia> ocorrencias = new ArrayList<>();

    // para que isso funcione na clsse destinatario temos que identificar que ela pode ser usada como embedded com o @Embeddable
    @Embedded // abstraimos o dado do destinatario para outra classe sem criar uma tabela destinatario
    @NotNull
    @Valid
    private Destinatario destinatario;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING) // queremos amazernar a string que representa a constante da enumeração, invés dos indices da enum
    private StatusEntrega statusEntrega;

    @NotNull
    private BigDecimal taxa;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataPedido;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // consumidor da api pode passar o dado, porém não sera considerado será ignorado
    private OffsetDateTime dataFinalizacao;

    public Ocorrencia adicionarOcorrencia(String descricao) {
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setDescricao(descricao);
        ocorrencia.setDataRegistro(OffsetDateTime.now());
        ocorrencia.setEntrega(this);
        this.getOcorrencias().add(ocorrencia);

        return ocorrencia;
    }
}
