package org.example.jwt.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.example.jwt.authen.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtFilter implements Filter {

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String authHeader = req.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            jwtProvider.validateToken(token);
        }

        chain.doFilter(request, response);
    }
}
