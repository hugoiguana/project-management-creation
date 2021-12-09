package com.hugo.mota.projectmanagementcreation.config.loader;

import com.hugo.mota.projectmanagementcreation.domain.ProfileEnum;
import com.hugo.mota.projectmanagementcreation.domain.UserSystemEntity;
import com.hugo.mota.projectmanagementcreation.repository.UserSystemEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;

@Profile("dev")
@Configuration
public class LoaderIni implements CommandLineRunner {

    @Autowired
    private UserSystemEntityRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private UserSystemEntity userSystemEntity;

    @Override
    public void run(String... args) throws Exception {
        insertDefaultEmployee();
    }

    @Transactional
    private void insertDefaultEmployee() {
        createFirstAdminUser();
    }

    private void createFirstAdminUser() {
        if (userRepository.findAll().isEmpty()) {
            userSystemEntity = new UserSystemEntity();
            userSystemEntity.setEmail("admin@email.com");
            userSystemEntity.setPassword(passwordEncoder.encode("1234"));
            userSystemEntity.setProfile(ProfileEnum.USER_ADMIN.getCode());
            userRepository.save(userSystemEntity);
        }
    }

}