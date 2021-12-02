package com.hugo.mota.projectmanagementcreation.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pmc_user")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class UserEntity extends PersistEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "profile")
    private Integer profile;

    @PrePersist
    public void prePersiste() {
        if (profile == null) {
            profile = ProfileEnum.USER_VIEWER.getCode();
        }
    }
}
