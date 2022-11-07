package com.algaloapi.service;

import com.algaloapi.domain.Cliente;
import com.algaloapi.domain.Entrega;
import com.algaloapi.enums.StatusEntrega;
import com.algaloapi.exceptions.NegocioException;
import com.algaloapi.repository.ClienteRepository;
import com.algaloapi.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EntregaService {

    private EntregaRepository entregaRepository;
    private ClienteRepository clienteRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = clienteRepository.findById(entrega.getCliente().getId()).orElseThrow(() -> new NegocioException("Cliente não encotnrado"));

        entrega.setStatusEntrega(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        entrega.setCliente(cliente);

        return entregaRepository.save(entrega);
    }


}
