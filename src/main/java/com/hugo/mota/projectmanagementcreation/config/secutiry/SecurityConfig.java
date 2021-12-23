package com.hugo.mota.projectmanagementcreation.config.secutiry;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import java.util.Arrays;

@KeycloakConfiguration
@Import(KeycloakSpringBootConfigResolver.class)
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {


    private static final String[] PUBLIC_MATCHERS = {
            "/h2-console/**"
    };

    private static final String[] PUBLIC_MATCHERS_GET = {
    };

    private static final String[] PUBLIC_MATCHERS_POST = {
    };

    @Autowired
    private Environment env;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = new KeycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    @Override
    @Bean
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        http.cors().and().csrf().disable();

        http.authorizeRequests()
                //.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
                //.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
                //.antMatchers(PUBLIC_MATCHERS).permitAll()
                .antMatchers(HttpMethod.GET, "/projects").hasAnyRole("ADMIN")
                .anyRequest().authenticated();
                //.anyRequest().permitAll();

        http.addFilter(new JWTAuthorizationFilter(authenticationManager()));
    }

    /*@Autowired
    private Environment env;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    private static final String[] PUBLIC_MATCHERS = {
            "/h2-console/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        http.cors().and().csrf().disable();

        http.authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated();

        http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
        http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity ws) throws Exception {
        ws.ignoring().antMatchers("/v2/api-docs"
                , "/configuration/ui"
                , "/swagger-resources/**"
                , "/configuration/**"
                , "/swagger-ui.html"
                , "/webjars/**");
    }*/

}
