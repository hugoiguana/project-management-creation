package com.hugo.mota.projectmanagementcreation.entity.mysql;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
