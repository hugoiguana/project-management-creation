package com.hugo.mota.projectmanagementcreation.repository;

import com.hugo.mota.projectmanagementcreation.domain.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProjectEntityRepository extends CrudRepository<ProjectEntity, Long> {
}