package com.agendapro.agendapro.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/statistics/**").authenticated() // Protege el endpoint de estadísticas
                        .requestMatchers("/api/products/**").permitAll() // Permite el acceso a los endpoints de productos
                        .anyRequest().permitAll() // Permite el acceso a otros endpoints
                )
                .httpBasic(withDefaults()) // Habilita la autenticación HTTP Basic
                .csrf(AbstractHttpConfigurer::disable); // Deshabilita CSRF para permitir solicitudes POST desde cualquier origen

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Define los usuarios en memoria
        var user = User.withUsername("user")
                .password("{noop}password") // {noop} se usa para indicar que la contraseña no está encriptada
                .roles("USER")
                .build();

        var admin = User.withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
