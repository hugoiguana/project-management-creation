package com.hugo.mota.projectmanagementcreation.service;

import com.hugo.mota.projectmanagementcreation.domain.UserProjectEntity;
import com.hugo.mota.projectmanagementcreation.domain.UserSystemEntity;
import com.hugo.mota.projectmanagementcreation.repository.UserProjectEntityRepository;
import com.hugo.mota.projectmanagementcreation.repository.UserSystemEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProjectServiceImpl implements UserProjectService {

    @Autowired
    private UserProjectEntityRepository userProjectEntityRepository;

    @Autowired
    private UserSystemEntityRepository userSystemEntityRepository;

    @Override
    public UserProjectEntity create(UserSystemEntity userSystemEntity) {
        return null;
    }
}
