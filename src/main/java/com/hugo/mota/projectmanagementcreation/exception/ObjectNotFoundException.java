package com.hugo.mota.projectmanagementcreation.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    public ObjectNotFoundException(String msg, String args) {
        super(String.format(msg, args));
    }
}