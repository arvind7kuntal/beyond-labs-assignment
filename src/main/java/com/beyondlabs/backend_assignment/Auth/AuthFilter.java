package com.beyondlabs.backend_assignment.Auth;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String token = req.getHeader("X-AUTH-TOKEN");

        if (token == null || !token.contains(":")) {
            String[] parts = token.split(":");
            String userId = parts[0];
            String role = parts[1];

            if (!role.equals("USER") && !role.equals("ADMIN")) {
                res.setStatus(401);
                res.setContentType("application/json");
                res.getWriter().write(("{errors:Unauthorirized"));

                return;
            }

            req.setAttribute("userId", userId);
            req.setAttribute("role", role);
            chain.doFilter(request, response);

        }
    }
}
