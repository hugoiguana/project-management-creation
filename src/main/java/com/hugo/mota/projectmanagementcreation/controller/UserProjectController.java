package com.hugo.mota.projectmanagementcreation.controller;

import com.hugo.mota.projectmanagementcreation.domain.UserProjectEntity;
import com.hugo.mota.projectmanagementcreation.domain.UserSystemEntity;
import com.hugo.mota.projectmanagementcreation.dto.UserProjectCreateRequestDto;
import com.hugo.mota.projectmanagementcreation.dto.UserProjectCreateResponseDto;
import com.hugo.mota.projectmanagementcreation.mapper.UserSystemMapper;
import com.hugo.mota.projectmanagementcreation.service.UserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users/project")
public class UserProjectController {

    @Autowired
    private UserProjectService userProjectService;

    @Autowired
    private UserSystemMapper userSystemMapper;


    @PostMapping
    public ResponseEntity<UserProjectCreateResponseDto> create(@RequestBody UserProjectCreateRequestDto userProjectCreateRequestDto) {
        UserSystemEntity userSystemEntity = userSystemMapper.toEntity(userProjectCreateRequestDto);
        UserProjectEntity userProjectEntity = userProjectService.create(userSystemEntity);
        UserProjectCreateResponseDto userProjectCreateResponseDto = userSystemMapper.toDto(userProjectEntity);
        return ResponseEntity.ok().body(userProjectCreateResponseDto);
    }

}
