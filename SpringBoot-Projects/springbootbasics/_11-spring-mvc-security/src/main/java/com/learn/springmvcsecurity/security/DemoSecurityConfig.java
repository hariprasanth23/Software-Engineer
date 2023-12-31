package com.learn.springmvcsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw,active from members where user_id=?"
        );
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );
        return jdbcUserDetailsManager;
        //return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        ).formLogin(form->
                form.loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll)
                .exceptionHandling(configurer->
                        configurer.accessDeniedPage("/access-denied")
                );
        return httpSecurity.build();
    }
}

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user1 = User.builder()
                .username("Hari1").password("{noop}Prasanth1").roles("EMPLOYEE").build();
        UserDetails user2 = User.builder()
                .username("Hari2").password("{noop}Prasanth2").roles("EMPLOYEE","MANAGER").build();
        UserDetails user3 = User.builder()
                .username("Hari3").password("{noop}Prasanth3")
                .roles("EMPLOYEE","MANAGER","ADMIN").build();
        return new InMemoryUserDetailsManager(user1,user2,user3);
    }


     */