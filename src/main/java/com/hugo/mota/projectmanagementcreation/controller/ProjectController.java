package com.hugo.mota.projectmanagementcreation.controller;

import com.hugo.mota.projectmanagementcreation.dto.ProjectAllResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @GetMapping
    //@PreAuthorize("hasAnyRole('APPROVER', 'CREATION', VIEWER', 'ADMIN')")
    //@PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<List<ProjectAllResponseDto>> all() {

        List<ProjectAllResponseDto> projectAllResponseDto = List.of(
                ProjectAllResponseDto.builder().id(1L).name("Project 1").build(),
                ProjectAllResponseDto.builder().id(2L).name("Project 2").build()
        );

        return ResponseEntity.ok().body(projectAllResponseDto);
    }

}
