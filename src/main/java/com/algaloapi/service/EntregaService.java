package com.algaloapi.service;

import com.algaloapi.domain.Cliente;
import com.algaloapi.domain.Entrega;
import com.algaloapi.enums.StatusEntrega;
import com.algaloapi.exceptions.NegocioException;
import com.algaloapi.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class EntregaService {

    private EntregaRepository entregaRepository;
    private ClienteService clienteService;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = clienteService.buscar(entrega.getCliente().getId());

        entrega.setStatusEntrega(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        entrega.setCliente(cliente);

        return entregaRepository.save(entrega);
    }

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId).orElseThrow(() -> new NegocioException("Entrega não encontrada"));
    }


}
