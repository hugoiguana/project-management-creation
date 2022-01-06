package com.hugo.mota.projectmanagementcreation.mapper;

import com.hugo.mota.projectmanagementcreation.dto.ProjectDto;
import com.hugo.mota.projectmanagementcreation.entity.mysql.ProjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Mapping(target = "id", ignore = true)
    ProjectEntity toEntity(ProjectDto projectDto);

    @Mapping(target = "id", ignore = true)
    void toEntity(ProjectDto projectDto, @MappingTarget ProjectEntity projectEntity);

    ProjectDto toDto(ProjectEntity projectEntity);

    List<ProjectDto> toDto(List<ProjectEntity> projectsEntity);
}
