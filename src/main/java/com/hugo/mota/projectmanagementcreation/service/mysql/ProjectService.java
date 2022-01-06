package com.hugo.mota.projectmanagementcreation.service.mysql;

import com.hugo.mota.projectmanagementcreation.dto.ProjectDto;
import com.hugo.mota.projectmanagementcreation.entity.mysql.ProjectEntity;

import java.util.List;

public interface ProjectService {
    ProjectDto create(ProjectDto projectDto);

    ProjectDto update(ProjectDto projectDto);

    List<ProjectDto> findAllOrderByNameAsc();

    void delete(Long id);

    ProjectEntity findByIdWithExceptionNotFound(Long id);
}
