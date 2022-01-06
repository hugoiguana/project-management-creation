package com.hugo.mota.projectmanagementcreation.controller;

import com.hugo.mota.projectmanagementcreation.dto.ProjectAllResponseDto;
import com.hugo.mota.projectmanagementcreation.dto.ProjectDto;
import com.hugo.mota.projectmanagementcreation.dto.groupValidation.ProjectUpdateGroupValidation;
import com.hugo.mota.projectmanagementcreation.entity.mysql.ProjectEntity;
import com.hugo.mota.projectmanagementcreation.mapper.ProjectMapper;
import com.hugo.mota.projectmanagementcreation.service.mysql.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectMapper projectMapper;

    @PostMapping
    public ResponseEntity<ProjectDto> create(@RequestBody @Valid ProjectDto projectDto) {
        projectDto = projectService.create(projectDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(projectDto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<ProjectDto> update(@RequestBody @Validated(ProjectUpdateGroupValidation.class) ProjectDto projectDto) {
        projectDto = projectService.update(projectDto);
        return ResponseEntity.ok().body(projectDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        projectService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto>findById(@PathVariable("id") Long id) {
        ProjectEntity projectsEntity = projectService.findByIdWithExceptionNotFound(id);
        ProjectDto projectDto = projectMapper.toDto(projectsEntity);
        return ResponseEntity.ok().body(projectDto);
    }

    //@PreAuthorize("hasAnyRole('APPROVER', 'CREATION', VIEWER', 'ADMIN')")
    //@PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ProjectDto>>all() {
        List<ProjectDto> projects = projectService.findAllOrderByNameAsc();
        return ResponseEntity.ok().body(projects);
    }

}
