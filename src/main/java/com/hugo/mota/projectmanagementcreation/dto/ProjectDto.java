package com.hugo.mota.projectmanagementcreation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.hugo.mota.projectmanagementcreation.dto.groupValidation.ProjectUpdateGroupValidation;
import com.hugo.mota.projectmanagementcreation.util.DateUtil;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDto implements Serializable {

    @NotNull(groups = ProjectUpdateGroupValidation.class)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = DateUtil.DATA_PATTERN)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateStart;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = DateUtil.DATA_PATTERN)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateEnd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
