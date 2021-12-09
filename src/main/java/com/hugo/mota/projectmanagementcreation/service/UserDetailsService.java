package com.hugo.mota.projectmanagementcreation.service;

import com.hugo.mota.projectmanagementcreation.config.secutiry.JWTUtil;
import com.hugo.mota.projectmanagementcreation.config.secutiry.UserSecurity;
import com.hugo.mota.projectmanagementcreation.domain.ProfileEnum;
import com.hugo.mota.projectmanagementcreation.domain.UserSystemEntity;
import com.hugo.mota.projectmanagementcreation.repository.UserSystemEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Arrays.asList;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserSystemEntityRepository employeeRepository;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserSystemEntity> employeeOptional = employeeRepository.findByEmail(email);
        UserSystemEntity employee = employeeOptional.orElseThrow(() -> new UsernameNotFoundException(email));
        return new UserSecurity(employee.getId(), employee.getEmail(), employee.getPassword(), asList(ProfileEnum.toEnum(employee.getProfile())));
    }

    public UserSecurity authenticated() {
        try {
            return (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }

    public UsernamePasswordAuthenticationToken getAuthentication(String token) {
        if (jwtUtil.tokenValido(token)) {
            String userName = jwtUtil.getUserName(token);
            UserDetails user = loadUserByUsername(userName);
            return new UsernamePasswordAuthenticationToken(user, user.getAuthorities(), user.getAuthorities());
        }
        return null;
    }
}
