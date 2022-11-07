package com.algaloapi.controller;

import com.algaloapi.domain.dto.OcorrenciaDTO;
import com.algaloapi.mapper.OcorrenciaMapper;
import com.algaloapi.service.OcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private OcorrenciaService ocorrenciaService;
    private OcorrenciaMapper ocorrenciaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDTO registrar(@RequestParam("descricao") String descricao, @PathVariable Long entregaId) {
        return ocorrenciaMapper.toDo(ocorrenciaService.registrar(entregaId, descricao));
    }

}
