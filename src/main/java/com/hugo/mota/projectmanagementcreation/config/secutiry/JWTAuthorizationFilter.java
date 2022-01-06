package com.hugo.mota.projectmanagementcreation.config.secutiry;

import com.hugo.mota.projectmanagementcreation.dto.UserJwtDto;
import com.hugo.mota.projectmanagementcreation.service.mongo.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    JWTUtil jwtUtil;
    UserService userService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserService userService) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        String token = SecurityUtil.getTokenBearerFromHeaderRequest(request);
        UserJwtDto userJwtDto = jwtUtil.convertTokenToUserJwtDto(token);
        userService.saveUser(userJwtDto);
        chain.doFilter(request, response);
    }

}