package com.project.bookstore.infraestructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/v1/authors/**", "/api/v1/categories/**", "/api/v1/publishers/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/v1/authors/**", "/api/v1/categories/**", "/api/v1/publishers/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/v1/authors/**", "/api/v1/categories/**", "/api/v1/publishers/**").permitAll()
                        .anyRequest().authenticated())
                        .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService users (PasswordEncoder passwordEncoder){
        UserDetails user1 = User.withUsername("monicabp")
                .password(passwordEncoder.encode("asdfghj147"))
                .roles("ADMIN", "USER")
                .build();

        UserDetails user2 = User.withUsername("silvanae05")
                .password(passwordEncoder.encode("pqrstuv-"))
                .roles("USER")
                .build();

        UserDetails user3 = User.withUsername("christian1")
                .password(passwordEncoder.encode("pppppp"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user1,user2, user3);
    }

}
