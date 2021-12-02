package com.hugo.mota.projectmanagementcreation.config.loader;

import com.hugo.mota.projectmanagementcreation.domain.ProfileEnum;
import com.hugo.mota.projectmanagementcreation.domain.UserEntity;
import com.hugo.mota.projectmanagementcreation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Profile("dev")
@Configuration
public class LoaderIni implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private UserEntity userEntity;

    @Override
    public void run(String... args) throws Exception {
        insertDefaultEmployee();
    }

    private void insertDefaultEmployee() {
        if (userRepository.findAll().isEmpty()) {
            userEntity = new UserEntity();
            userEntity.setName("Admin");
            userEntity.setEmail("admin@email.com");
            userEntity.setCpf("01234567891");
            userEntity.setPassword(passwordEncoder.encode("1234"));
            userEntity.setProfile(ProfileEnum.USER_ADMIN.getCode());
            userRepository.save(userEntity);
        }
    }

}