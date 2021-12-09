package com.hugo.mota.projectmanagementcreation.mapper;

import com.hugo.mota.projectmanagementcreation.domain.UserProjectEntity;
import com.hugo.mota.projectmanagementcreation.domain.UserSystemEntity;
import com.hugo.mota.projectmanagementcreation.dto.UserProjectCreateRequestDto;
import com.hugo.mota.projectmanagementcreation.dto.UserProjectCreateResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserSystemMapper {

    UserSystemEntity toEntity(UserProjectCreateRequestDto userProjectCreateRequestDto);

    UserProjectCreateResponseDto toDto(UserProjectEntity userSystemEntity);
}
