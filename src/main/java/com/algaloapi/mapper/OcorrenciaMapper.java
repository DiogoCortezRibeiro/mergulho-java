package com.algaloapi.mapper;

import com.algaloapi.domain.Ocorrencia;
import com.algaloapi.domain.dto.OcorrenciaDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OcorrenciaMapper {

    private ModelMapper modelMapper;

    public OcorrenciaDTO toDo(Ocorrencia ocorrencia) {
        return modelMapper.map(ocorrencia, OcorrenciaDTO.class);
    }

}
