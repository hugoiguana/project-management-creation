package com.hugo.mota.projectmanagementcreation.mapper;

import com.hugo.mota.projectmanagementcreation.dto.UserDto;
import com.hugo.mota.projectmanagementcreation.dto.UserJwtDto;
import com.hugo.mota.projectmanagementcreation.entity.mongo.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {

    @Mapping(source = "name", target = "fullName")
    @Mapping(source = "preferred_username", target = "username")
    @Mapping(source = "given_name", target = "firstName")
    @Mapping(source = "family_name", target = "lastName")
    @Mapping(source = "realm_access.roles", target = "roles")
    UserDto toDto(UserJwtDto userJwtDto);

    @Mapping(target = "id", ignore = true)
    UserEntity toEntity(UserDto userDto);

    @Mapping(target = "id", ignore = true)
    void toEntity(UserDto userDto, @MappingTarget UserEntity userEntity);


    UserDto toDto(UserEntity userEntity);
}
