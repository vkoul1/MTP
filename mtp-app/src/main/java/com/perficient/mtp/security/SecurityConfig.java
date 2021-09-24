package com.perficient.mtp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity http) throws Exception {
    	
    	
        http.authorizeExchange()
                .pathMatchers("/", "/error", "/logout", "/webjars/**").permitAll()
                .anyExchange().authenticated()
                .and().oauth2Login()
                .and().csrf().disable()
                ;
        
        return http.build();
    }
}
