package com.algaloapi.mapper;

import com.algaloapi.domain.Entrega;
import com.algaloapi.domain.dto.EntregaDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EntregaMapper {

    private ModelMapper modelMapper;

    public EntregaDTO toDTO(Entrega entrega) {
        return modelMapper.map(entrega, EntregaDTO.class);
    }
}
