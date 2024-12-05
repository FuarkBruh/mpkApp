package com.example.mpkApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Wyłączamy CSRF dla całej aplikacji (lub można to zrobić tylko dla /login)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/login").permitAll() // Dostęp do formularza logowania
                        .requestMatchers("/adminStrona").hasRole("ADMINISTRATOR") // Tylko użytkownicy z rolą ADMINISTRATOR mogą zobaczyć stronę adminStrona
                        .anyRequest().permitAll() // Inne strony są dostępne publicznie
                )
                .formLogin((form) -> form
                        .loginPage("/login")  // Własna strona logowania
                        .defaultSuccessUrl("/adminStrona", true)  // Po zalogowaniu przekierowanie do strony admin
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }



    @Bean
    public UserDetailsService userDetailsService() {
        // Używamy BCryptPasswordEncoder do zakodowania hasła
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String zakodowaneHaslo = passwordEncoder.encode("admin");

        UserDetails user = User.builder()
                .username("admin")
                .password(zakodowaneHaslo)
                .roles("ADMINISTRATOR")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Zwracamy instancję BCryptPasswordEncoder
    }
}
