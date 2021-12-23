package com.hugo.mota.projectmanagementcreation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectAllResponseDto {

    private Long id;
    private String name;

}
