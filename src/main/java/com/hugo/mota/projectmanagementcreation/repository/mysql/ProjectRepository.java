package com.hugo.mota.projectmanagementcreation.repository.mysql;

import com.hugo.mota.projectmanagementcreation.entity.mysql.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {
    List<ProjectEntity> findAllByOrderByNameAsc();
}