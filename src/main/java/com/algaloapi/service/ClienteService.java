package com.algaloapi.service;

import com.algaloapi.domain.Cliente;
import com.algaloapi.exceptions.NegocioException;
import com.algaloapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public ResponseEntity<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id).map(cliente -> ResponseEntity.ok(cliente)).orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()).stream().anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if(emailEmUso) {
            throw new NegocioException("E-mail já cadastrado no sistema");
        }

        return clienteRepository.save(cliente);
    }

    public Cliente buscar(Long ClienteId) {
        return clienteRepository.findById(ClienteId).orElseThrow(() -> new NegocioException("Cliente não encotnrado"));
    }

    public boolean clienteExiste(Long id) {
        return clienteRepository.existsById(id);
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
