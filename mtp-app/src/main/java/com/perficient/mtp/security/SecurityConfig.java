package com.perficient.mtp.security;

import java.net.URI;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.authentication.logout.RedirectServerLogoutSuccessHandler;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;

@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity http) throws Exception {
    	
        return http.authorizeExchange()
                .pathMatchers("/", "/error", "/images/*", "/webjars/**").permitAll()
                .anyExchange().authenticated()
                .and().oauth2Login()
                		.authenticationSuccessHandler(mtpAuthenticationSuccessHandler("/mtp/home.html"))
                .and().logout()
                		.logoutSuccessHandler(mtpServerLogoutSuccessHandler("/"))
                .and().csrf()
                		.disable()
                .build();
    }
    
    
    public ServerAuthenticationSuccessHandler mtpAuthenticationSuccessHandler(String uri) {
    	return new RedirectServerAuthenticationSuccessHandler(uri);
    }
    
    
    public ServerLogoutSuccessHandler mtpServerLogoutSuccessHandler(String uri) {
    	
    	RedirectServerLogoutSuccessHandler h = new RedirectServerLogoutSuccessHandler();
    	h.setLogoutSuccessUrl(URI.create(uri));
    	return h;
    }
}
