package com.hugo.mota.projectmanagementcreation.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class PersistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_creation", nullable = false)
    private LocalDateTime dateCreation;

    @Column(name = "dt_update", nullable = false)
    private LocalDateTime dateUpdate;


    @PrePersist
    public void prePersist() {
        dateCreation = LocalDateTime.now();
        dateUpdate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        dateUpdate = LocalDateTime.now();
    }
}
