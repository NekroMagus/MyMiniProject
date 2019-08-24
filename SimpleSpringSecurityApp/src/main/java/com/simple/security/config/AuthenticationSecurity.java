package com.simple.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Configuration
public class AuthenticationSecurity implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> grantedAuthorities = authentication.getAuthorities();

        if(grantedAuthorities.contains(new SimpleGrantedAuthority("ADMIN"))) {
            response.sendRedirect("/admin");
        }
        else if(grantedAuthorities.contains(new SimpleGrantedAuthority("USER"))) {
            response.sendRedirect("/users");
        }
    }
}
