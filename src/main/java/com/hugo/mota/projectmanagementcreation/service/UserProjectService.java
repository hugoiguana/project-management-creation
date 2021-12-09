package com.hugo.mota.projectmanagementcreation.service;

import com.hugo.mota.projectmanagementcreation.domain.UserProjectEntity;
import com.hugo.mota.projectmanagementcreation.domain.UserSystemEntity;

public interface UserProjectService {
    UserProjectEntity create(UserSystemEntity userSystemEntity);
}
