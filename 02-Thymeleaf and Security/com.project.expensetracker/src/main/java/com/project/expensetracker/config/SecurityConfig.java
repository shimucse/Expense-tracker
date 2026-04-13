package com.project.expensetracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

      @Bean
        public InMemoryUserDetailsManager userDetailsManager() {

                UserDetails user = User.builder()
                        .username("user")
                        .password("{noop}1234")
                        .roles("USER")
                        .build();
                UserDetails admin = User.builder()
                        .username("admin")
                        .password("{noop}1234")
                        .roles("ADMIN")
                        .build();

                return new InMemoryUserDetailsManager(user,admin);
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

                http
                        .authorizeHttpRequests(config -> config
                                .requestMatchers("/", "/showLoginPage", "/css/**", "/js/**").permitAll()
                                //User+ADMIN
                                .requestMatchers("/expenses/list").hasAnyRole("USER","ADMIN")
                                //Only ADMIN
                                .requestMatchers("/expenses/dashboard").hasRole("ADMIN")
                                .requestMatchers("/expenses/delete/**").hasRole("ADMIN")

                                .anyRequest().authenticated()
                        )
                        .formLogin(form -> form
                                .loginPage("/")
                                .loginProcessingUrl("/authenticateTheUser")
                                .defaultSuccessUrl("/home", true)
                                .permitAll()
                        )
                        .exceptionHandling(config->
                                config.accessDeniedPage("/access-denied"))
                        .logout(logout -> logout.permitAll()
                        );

                return http.build();
        }
}