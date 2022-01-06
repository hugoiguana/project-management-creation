package com.hugo.mota.projectmanagementcreation.config.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Profile("dev")
@Configuration
public class LoaderIni implements CommandLineRunner {

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void run(String... args) throws Exception {
    }



}