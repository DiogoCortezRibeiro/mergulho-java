package com.algaloapi.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // declara que é um componente spring de configuraçao de beans
public class ModelMapperConfig {

    @Bean // esse método inicializa e configura um bean que será gerenciado pelo spring, o que deixara livre pra injeção de dependecia pra outras classes
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
