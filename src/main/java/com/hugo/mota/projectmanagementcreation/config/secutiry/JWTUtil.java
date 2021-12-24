package com.hugo.mota.projectmanagementcreation.config.secutiry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hugo.mota.projectmanagementcreation.dto.UserJwtDto;
import com.hugo.mota.projectmanagementcreation.exception.TokenInvalidException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
@Slf4j
public class JWTUtil {

    public static final int TOKEN_PAYLOAD_POSITION_IN_ARRAY = 1;
    public static final String TOKEN_SPLIT_REGEX = "\\.";
    public static final int TOKEN_MINIMAL_SIZE = 2;

    @Autowired
    ObjectMapper jacksonMapper;

    @SneakyThrows
    public UserJwtDto convertTokenToUserJwtDto(String token) {
        String[] chunks = validateToken(token);
        Base64.Decoder decoder = Base64.getDecoder();
        String payload = new String(decoder.decode(chunks[TOKEN_PAYLOAD_POSITION_IN_ARRAY]));

        UserJwtDto userJwtDto;
        try {
            userJwtDto = jacksonMapper.readValue(payload, UserJwtDto.class);
        } catch (JsonProcessingException e) {
            log.info("Error on converting Jwt Token to Object.");
            log.info(e.getMessage());
            throw new TokenInvalidException("Error on converting Jwt Token to Object.");
        }
        return userJwtDto;
    }

    private String[] validateToken(String token) {
        String[] chunks = token.split(TOKEN_SPLIT_REGEX);
        if (chunks.length < TOKEN_MINIMAL_SIZE) {
            log.info("Error on split token.");
            throw new TokenInvalidException("Error on split token.");
        }
        return chunks;
    }

}