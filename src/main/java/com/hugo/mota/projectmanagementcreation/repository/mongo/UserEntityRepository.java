package com.hugo.mota.projectmanagementcreation.repository.mongo;

import com.hugo.mota.projectmanagementcreation.entity.mongo.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends MongoRepository<UserEntity, Long> {

    UserEntity findByUsername(String userName);
}
