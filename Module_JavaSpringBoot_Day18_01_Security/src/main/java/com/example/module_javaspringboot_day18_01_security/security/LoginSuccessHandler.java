package com.example.module_javaspringboot_day18_01_security.security;

import com.example.module_javaspringboot_day18_01_security.entities.PermissionEntity;
import com.example.module_javaspringboot_day18_01_security.entities.UserEntity;
import com.example.module_javaspringboot_day18_01_security.repository.IRoleRepository;
import com.example.module_javaspringboot_day18_01_security.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    IRoleRepository roleRepository;
    @Autowired
    UserService userService;
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        List<SimpleGrantedAuthority> roleEntities = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
//        CustomerService userEntity = (CustomerService) authentication.getPrincipal();

        String username = request.getParameter("username");
        UserEntity userEntity = iUserRepository.findByUsername(username);
//        List<PermissionEntity> entityList = userEntity.getRoleEntityList().get(0).getPermissionEntityList();

        HttpSession session = request.getSession();
        if (session != null){
            session.setAttribute("user",userEntity);
        }
        for (SimpleGrantedAuthority simple : roleEntities) {
            if (simple.getAuthority().equals("ROLE_ADMIN")) {
                response.sendRedirect("/admin");
            }else if (simple.getAuthority().equals("ROLE_MENTOR")){
                response.sendRedirect("/home");
            }else if (simple.getAuthority().equals("ROLE_USER")){
                response.sendRedirect("/home");
            }
        }
    }
}
