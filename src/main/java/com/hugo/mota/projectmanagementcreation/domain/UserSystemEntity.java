package com.hugo.mota.projectmanagementcreation.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrePersist;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pmc_user_system")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class UserSystemEntity extends PersistEntity {

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "profile", nullable = false)
    private Integer profile;

    @PrePersist
    public void prePersiste() {
        if (profile == null) {
            profile = ProfileEnum.USER_VIEWER.getCode();
        }
    }
}
