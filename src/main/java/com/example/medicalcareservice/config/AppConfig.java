package com.example.medicalcareservice.config;

import com.example.medicalcareservice.model.GenderType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    public AppConfig(ObjectMapper objectMapper) {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(GenderType.class, new GenderTypeDeserializer());
        objectMapper.registerModule(module);
    }

}