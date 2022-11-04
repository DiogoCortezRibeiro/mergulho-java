package com.algaloapi.repository;

import com.algaloapi.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome); // usando o LIKE do sql
    Optional<Cliente> findByEmail(String email);
}
