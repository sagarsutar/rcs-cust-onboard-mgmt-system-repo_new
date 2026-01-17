package com.tcl.assignemnt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
/***
 * SecurityConfig is used for the security related information
 * @author Sagar
 *
 */
@Configuration
@EnableMethodSecurity 
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/h2-console/**",
                    "/swagger-ui/**",
                    "/v3/api-docs/**"
                ).permitAll()
                //.anyRequest().permitAll()  
             // Form APIs
                .requestMatchers("/api/forms/**")
                .hasAnyRole("ADMIN", "TPM")

                // Submission APIs
                .requestMatchers("/api/submissions/**")
                .hasAnyRole("CUSTOMER", "ADMIN", "TPM", "SALES")

                // Review APIs
                .requestMatchers("/api/reviews/**")
                .hasAnyRole("TPM", "SALES", "ADMIN")

                // Query APIs
                .requestMatchers("/api/submissions/**")
                .hasAnyRole("CUSTOMER", "TPM", "SALES", "ADMIN")

                // Any other request
                .anyRequest().authenticated()
            )
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))
            .httpBasic(Customizer.withDefaults());
        
        

        return http.build();
    }
    
    @Bean
    public UserDetailsService users() {
        return new InMemoryUserDetailsManager(
            User.withUsername("customer")
                .password("{noop}password")
                .roles("CUSTOMER")
                .build(),
            User.withUsername("tpm")
                .password("{noop}password")
                .roles("TPM")
                .build(),
            User.withUsername("sales")
                .password("{noop}password")
                .roles("SALES")
                .build(),
            User.withUsername("admin")
                .password("{noop}password")
                .roles("ADMIN")
                .build()
        );
    }

}