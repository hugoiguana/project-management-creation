package com.hugo.mota.projectmanagementcreation.service.mongo;

import com.hugo.mota.projectmanagementcreation.dto.UserDto;
import com.hugo.mota.projectmanagementcreation.dto.UserJwtDto;
import com.hugo.mota.projectmanagementcreation.entity.mongo.UserEntity;
import com.hugo.mota.projectmanagementcreation.mapper.UserMapper;
import com.hugo.mota.projectmanagementcreation.repository.mongo.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import static java.util.Objects.isNull;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserEntityRepository userRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDto getByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        return userMapper.toDto(userEntity);
    }

    @Override
    public UserDto saveUser(UserJwtDto userJwtDto) {
        UserDto userDto = userMapper.toDto(userJwtDto);
        UserEntity userEntity = userRepository.findByUsername(userDto.getUsername());

        if (isNull(userEntity)) {
            Long idUser = sequenceGeneratorService.generateSequence(UserEntity.SEQUENCE_USER);
            userEntity = userMapper.toEntity(userDto);
            userEntity.setId(idUser);
        } else {
            userMapper.toEntity(userDto, userEntity);
        }

        userEntity = userRepository.save(userEntity);
        return userMapper.toDto(userEntity);
    }
}
