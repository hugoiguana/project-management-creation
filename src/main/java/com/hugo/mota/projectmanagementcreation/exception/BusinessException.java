package com.hugo.mota.projectmanagementcreation.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BusinessException extends RuntimeException {

    public BusinessException(String msg) {
        super(msg);
    }

}