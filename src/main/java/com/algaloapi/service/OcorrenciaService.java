package com.algaloapi.service;

import com.algaloapi.domain.Entrega;
import com.algaloapi.domain.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OcorrenciaService {

    private EntregaService entregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao) {
        Entrega entrega = entregaService.buscar(entregaId);
        // nao precisamos chamar o save pois o @transational sincroniza já qualquer alteração ja no obj entrega neste caso assim que concluido
        return entrega.adicionarOcorrencia(descricao);
    }
}
