package com.hugo.mota.projectmanagementcreation.service.mongo;

import com.hugo.mota.projectmanagementcreation.dto.UserDto;
import com.hugo.mota.projectmanagementcreation.dto.UserJwtDto;

public interface UserService {

    UserDto getByUsername(String username);

    UserDto saveUser(UserJwtDto userJwtDto);
}
