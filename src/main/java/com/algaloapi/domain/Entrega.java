package com.algaloapi.domain;

import com.algaloapi.enums.StatusEntrega;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // vai vincular na tabela com base no cliente_id criado na tabela
    private Cliente cliente;

    // para que isso funcione na clsse destinatario temos que identificar que ela pode ser usada como embedded com o @Embeddable
    @Embedded // abstraimos o dado do destinatario para outra classe sem criar uma tabela destinatario
    private Destinatario destinatario;

    @Enumerated(EnumType.STRING) // queremos amazernar a string que representa a constante da enumeração, invés dos indices da enum
    private StatusEntrega statusEntrega;

    private BigDecimal taxa;
    private LocalDateTime dataPedido;
    private LocalDateTime dataFinalizacao;

}
