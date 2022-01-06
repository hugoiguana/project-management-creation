package com.hugo.mota.projectmanagementcreation.controller;

import com.hugo.mota.projectmanagementcreation.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users/project")
public class UserProjectController {


    @Autowired
    private UserMapper userSystemMapper;


  /*  @PostMapping
    public ResponseEntity<UserProjectCreateResponseDto> create(@RequestBody UserProjectCreateRequestDto userProjectCreateRequestDto) {
        UserSystemEntity userSystemEntity = userSystemMapper.toEntity(userProjectCreateRequestDto);
        UserProjectEntity userProjectEntity = userProjectService.create(userSystemEntity);
        UserProjectCreateResponseDto userProjectCreateResponseDto = userSystemMapper.toDto(userProjectEntity);
        return ResponseEntity.ok().body(userProjectCreateResponseDto);
    }*/

}
