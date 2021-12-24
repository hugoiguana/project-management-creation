package com.hugo.mota.projectmanagementcreation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserJwtDto {

    private String name;
    private String preferred_username;
    private String given_name;
    private String family_name;
    private UserJwtRealmAccess realm_access;

    @Getter
    @Setter
    public static class UserJwtRealmAccess {
        private List<String> roles = new ArrayList<>();
    }

}
