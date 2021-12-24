package com.hugo.mota.projectmanagementcreation.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TokenInvalidException extends RuntimeException {

    public TokenInvalidException(String msg) {
        super(msg);
    }

}