package com.example.module_javaspringboot_day22_01_practice.security.oauth2;

import com.example.module_javaspringboot_day22_01_practice.config.AuthProvider;
import com.example.module_javaspringboot_day22_01_practice.entities.RoleEntity;
import com.example.module_javaspringboot_day22_01_practice.entities.UserEntity;
import com.example.module_javaspringboot_day22_01_practice.repository.IRoleRepository;
import com.example.module_javaspringboot_day22_01_practice.repository.IUserRepository;
import com.example.module_javaspringboot_day22_01_practice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    IRoleRepository iRoleRepository;
    @Autowired
    UserServiceImpl userService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        CustomOAuth2UserImpl customOAuth2User = (CustomOAuth2UserImpl) authentication.getPrincipal();

        String email = customOAuth2User.getEmail();
        String username = customOAuth2User.getName();
        String clientName = customOAuth2User.getClientName();
        String idClient = customOAuth2User.getID();
        String accessToken = customOAuth2User.getAccessToken();
        String tokenType = customOAuth2User.getTokenType();


        UserEntity userEntity = iUserRepository.findByEmail(email);

        AuthProvider authProvider = null;
        if (clientName.equals("Facebook")){
            authProvider = AuthProvider.FACEBOOK;
        }else if (clientName.equals("Google")){
            authProvider = AuthProvider.GOOGLE;
        }else {
            authProvider = AuthProvider.LOCAL;
        }
        HttpSession session = request.getSession();
        if (session.getAttribute("userLogin") == null){
            session.setAttribute("userLogin",userEntity);
        }

        RoleEntity roleEntity = iRoleRepository.getById(2L);
        List<RoleEntity> listRole = new ArrayList<>();
        listRole.add(roleEntity);

        if (userEntity == null){
            UserEntity newUser = new UserEntity();
            newUser.setId(null);
            newUser.setUsername(username);
            newUser.setEmail(email);
            newUser.setEnabled(true);
            newUser.setAuthProvider(authProvider);
            newUser.setRoleEntityList(listRole);
            userService.saveUser(newUser);
        }else {
            userEntity.setAuthProvider(authProvider);
            userEntity.setUsername(username);
            userEntity.setEmail(email);
            userService.saveUser(userEntity);
        }

        request.getRequestDispatcher("/home").forward(request,response);
    }
}
