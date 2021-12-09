package com.hugo.mota.projectmanagementcreation.repository;

import com.hugo.mota.projectmanagementcreation.domain.UserSystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSystemEntityRepository extends JpaRepository<UserSystemEntity, Long> {

    Optional<UserSystemEntity> findByEmail(String email);

}