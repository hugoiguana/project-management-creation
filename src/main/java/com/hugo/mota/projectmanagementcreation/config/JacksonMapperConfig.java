package com.hugo.mota.projectmanagementcreation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JacksonMapperConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
