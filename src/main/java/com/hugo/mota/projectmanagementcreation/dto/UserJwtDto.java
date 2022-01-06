package com.hugo.mota.projectmanagementcreation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    public static class UserJwtRealmAccess {
        private List<String> roles = new ArrayList<>();

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreferred_username() {
        return preferred_username;
    }

    public void setPreferred_username(String preferred_username) {
        this.preferred_username = preferred_username;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public UserJwtRealmAccess getRealm_access() {
        return realm_access;
    }

    public void setRealm_access(UserJwtRealmAccess realm_access) {
        this.realm_access = realm_access;
    }
}
