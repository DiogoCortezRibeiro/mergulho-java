package com.algaloapi.controller;

import com.algaloapi.domain.Entrega;
import com.algaloapi.domain.dto.EntregaDTO;
import com.algaloapi.mapper.EntregaMapper;
import com.algaloapi.repository.EntregaRepository;
import com.algaloapi.service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaService entregaService;

    private EntregaRepository entregaRepository;
    private EntregaMapper entregaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDTO solicitar(@Valid @RequestBody Entrega entrega) {
        return entregaMapper.toDTO(entregaService.solicitar(entrega));
    }

    @GetMapping
    public List<EntregaDTO> listar() {
        return entregaMapper.toCollectionDTO(entregaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaDTO> buscarPorId(@PathVariable Long id) {
        return entregaRepository.findById(id).map(entrega -> {
            // para utilizar o modelMapper aqui precisamos cria rum Bean para ele, se não o spring
            // não consegue fazer a injeção dele neste ponto da aplicação
            // configuração será feita na classe ModelMapperConfig
              EntregaDTO entregaDTO =  entregaMapper.toDTO(entrega);

//            EntregaDTO entregaDTO = new EntregaDTO();
//            entregaDTO.setStatus(entrega.getStatusEntrega());
//            entregaDTO.setId(entrega.getId());
//            entregaDTO.setDataFinalizacao(entrega.getDataFinalizacao());
//            entregaDTO.setDataPedido(entrega.getDataPedido());
//            entregaDTO.setDestinatario(new DestinatarioDTO());
//            entregaDTO.getDestinatario().setNome(entrega.getDestinatario().getNome());
//            entregaDTO.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
//            entregaDTO.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
//            entregaDTO.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
//            entregaDTO.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
//            entregaDTO.setNomeCliente(entrega.getCliente().getNome());
//            entregaDTO.setTaxa(entrega.getTaxa());

            return ResponseEntity.ok(entregaDTO);
        }).orElse(ResponseEntity.notFound().build());
    }
}
