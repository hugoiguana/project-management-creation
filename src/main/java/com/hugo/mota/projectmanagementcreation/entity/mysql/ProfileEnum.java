package com.hugo.mota.projectmanagementcreation.entity.mysql;

import lombok.Getter;

@Getter
public enum ProfileEnum {

    USER_CREATION(1, "CREATION"),
    USER_VIEWER(2, "VIEWER"),
    USER_APPROVER(3, "APPROVER"),
    USER_ADMIN(3, "ADMIN");

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