package com.example.module_javaspringboot_finalproject.security.oauth2;

import com.example.module_javaspringboot_finalproject.config.AuthProvider;
import com.example.module_javaspringboot_finalproject.entities.RoleEntity;
import com.example.module_javaspringboot_finalproject.entities.UserEntity;
import com.example.module_javaspringboot_finalproject.repository.RoleRepository;
import com.example.module_javaspringboot_finalproject.repository.UserRepository;
import com.example.module_javaspringboot_finalproject.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    UserRepository iUserRepository;
    @Autowired
    RoleRepository iRoleRepository;
    @Autowired
    UserServiceImpl userService;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        CustomOAuth2UserImpl customOAuth2User = (CustomOAuth2UserImpl) authentication.getPrincipal();

        String email = customOAuth2User.getEmail();
        String username = customOAuth2User.getName();
        String clientName = customOAuth2User.getClientName();
        String idClient = customOAuth2User.getID();
        String accessToken = customOAuth2User.getAccessToken();
        String tokenType = customOAuth2User.getTokenType();


        String urlImageFacebookOrGG ="";
        String alphaAndDigits ="";
        Path pathStatic = Paths.get("src/main/resources/static/avatars");

        String userUpLoadPath = pathStatic.toFile().getAbsolutePath();
//        String userUpLoadPath = "/Users/admin/Desktop/Module_JavaSpingBoot/Module_JavaSpringBoot_FinalProject/src/main/resources/images";
        System.out.println("ahihi + " + userUpLoadPath);
        UserEntity userEntity = iUserRepository.findByEmail(email);

        AuthProvider authProvider = null;
        if (clientName.equals("Facebook")){
            urlImageFacebookOrGG = "https://graph.facebook.com/"+idClient+"/picture?type=large&access_token="+accessToken;
            alphaAndDigits = username.replaceAll("\\s+", "")+idClient;
            authProvider = AuthProvider.FACEBOOK;
        }else if (clientName.equals("Google")){
            urlImageFacebookOrGG = customOAuth2User.getImage();
            alphaAndDigits = username.replaceAll("\\s+", "")+customOAuth2User.getSubGG();
            authProvider = AuthProvider.GOOGLE;
        }else {
            authProvider = AuthProvider.LOCAL;
        }

        String imageName = alphaAndDigits.replaceAll("[^a-zA-Z0-9]+","")+".jpg";
        String pathImages = userUpLoadPath +"/"+imageName;

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
            newUser.setAvatar(imageName);
            iUserRepository.save(newUser);
        }else {
            userEntity.setAuthProvider(authProvider);
            userEntity.setUsername(username);
            userEntity.setEmail(email);
            userEntity.setAvatar(imageName);
            iUserRepository.save(userEntity);
        }
        userService.downloadImage(urlImageFacebookOrGG,pathImages);

        redirectStrategy.sendRedirect(request, response, "/user/home");
//        request.getRequestDispatcher("/user/home").forward(request,response);
    }
}
