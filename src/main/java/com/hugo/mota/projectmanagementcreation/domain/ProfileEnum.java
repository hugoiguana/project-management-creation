package com.hugo.mota.projectmanagementcreation.domain;

import lombok.Getter;

@Getter
public enum ProfileEnum {

    USER_CREATION(1, "ROLE_USER_CREATION"),
    USER_VIEWER(2, "ROLE_USER_VIEWER"),
    USER_APPROVER(3, "ROLE_USER_APPROVER"),
    USER_ADMIN(3, "ROLE_USER_APPROVER");

    private int code;
    private String role;

    ProfileEnum(Integer code, String role) {
        this.code = code;
        this.role = role;
    }

    public static ProfileEnum toEnum(Integer cod) {
        for (ProfileEnum p : ProfileEnum.values()) {
            if (cod.equals(p.getCode())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + cod);
    }
}