package com.example.module_javaspringboot_day17_01_security.service;

import com.example.module_javaspringboot_day17_01_security.entities.UserEntity;
import com.example.module_javaspringboot_day17_01_security.repository.RoleRepository;
import com.example.module_javaspringboot_day17_01_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserService userService;
//    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//    public static String usename = "";
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        authentication = SecurityContextHolder.getContext().getAuthentication();
//        usename = authentication.getName();
        List<SimpleGrantedAuthority> roleEntities = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        CustomUser userEntity = (CustomUser) authentication.getPrincipal();
        if (userEntity.getFailAttempt() > 0) {
            userService.resetFailedAttempts(userEntity.getUsername());
        }
//
//        if (userEntity.getAuthorities().contains("ROLE_ADMIN")){
//            redirectStrategy.sendRedirect(request,response,"/admin");
//            response.sendRedirect("/admin");
//        }else if (userEntity.getAuthorities().contains("ROLE_USER")){
//            redirectStrategy.sendRedirect(request,response,"/home");
//        }
//
//
//
//        if (roleEntities.contains(roleRepository.findByRole("ROLE_ADMIN"))){
//            redirectStrategy.sendRedirect(request,response,"/admin");
//
//        }else if(roleEntities.contains(roleRepository.findByRole("ROLE_USER"))){
//            redirectStrategy.sendRedirect(request,response,"/home");
//        }


        for (SimpleGrantedAuthority simple : roleEntities) {
            if (simple.getAuthority().equals("ROLE_ADMIN")) {
                response.sendRedirect("/admin");
            }else if (simple.getAuthority().equals("ROLE_USER")){
                response.sendRedirect("/home");
            }
        }
    }
}
