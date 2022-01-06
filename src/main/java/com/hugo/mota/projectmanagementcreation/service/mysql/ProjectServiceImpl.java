package com.hugo.mota.projectmanagementcreation.service.mysql;

import com.hugo.mota.projectmanagementcreation.dto.ProjectDto;
import com.hugo.mota.projectmanagementcreation.entity.mysql.ProjectEntity;
import com.hugo.mota.projectmanagementcreation.exception.ObjectNotFoundException;
import com.hugo.mota.projectmanagementcreation.mapper.ProjectMapper;
import com.hugo.mota.projectmanagementcreation.repository.mysql.ProjectRepository;
import com.hugo.mota.projectmanagementcreation.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectMapper projectMapper;

    @Override
    @Transactional
    public ProjectDto create(ProjectDto projectDto) {
        ProjectEntity projectEntity = projectMapper.toEntity(projectDto);
        projectRepository.save(projectEntity);
        return projectMapper.toDto(projectEntity);
    }

    @Override
    @Transactional
    public ProjectDto update(ProjectDto projectDto) {
        ProjectEntity projectEntity = findByIdWithExceptionNotFound(projectDto.getId());
        projectMapper.toEntity(projectDto, projectEntity);
        return projectDto;
    }

    @Override
    public List<ProjectDto> findAllOrderByNameAsc() {
        List<ProjectEntity> projects = projectRepository.findAllByOrderByNameAsc();
        return projectMapper.toDto(projects);
    }

    @Override
    public void delete(Long id) {
        ProjectEntity projectEntity = findByIdWithExceptionNotFound(id);

        projectRepository.delete(projectEntity);
    }

    @Override
    public ProjectEntity findByIdWithExceptionNotFound(Long id) {
        ProjectEntity projectEntity = projectRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(String.format(MessageUtil.MSG_ERROR_PROJECT_NOT_FOUND, id)));
        return projectEntity;
    }

}
