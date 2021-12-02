package com.hugo.mota.projectmanagementcreation.service;

import com.hugo.mota.projectmanagementcreation.config.secutiry.JWTUtil;
import com.hugo.mota.projectmanagementcreation.config.secutiry.UserSecurity;
import com.hugo.mota.projectmanagementcreation.domain.ProfileEnum;
import com.hugo.mota.projectmanagementcreation.domain.UserEntity;
import com.hugo.mota.projectmanagementcreation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Arrays.asList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository employeeRepository;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> employeeOptional = employeeRepository.findByEmail(email);
        UserEntity employee = employeeOptional.orElseThrow(() -> new UsernameNotFoundException(email));
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
