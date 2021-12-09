package com.hugo.mota.projectmanagementcreation.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserProjectCreateRequestDto {

    private String name;
    private String email;
    private Integer profile;

}
