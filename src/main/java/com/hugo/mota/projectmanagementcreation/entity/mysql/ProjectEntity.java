package com.hugo.mota.projectmanagementcreation.entity.mysql;

import javax.persistence.*;
import java.time.LocalDate;

import static java.util.Objects.isNull;

@Entity
@Table(name = "pmc_project")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class ProjectEntity extends PersistEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "dt_start")
    private LocalDate dateStart;

    @Column(name = "dt_end")
    private LocalDate dateEnd;


    @PrePersist
    public void prePersist() {
        super.prePersist();
        if (isNull(dateStart)) {
            dateStart = LocalDate.now();
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }
}
