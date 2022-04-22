package com.example.module_javaspringboot_day18_01_security.config;

import com.example.module_javaspringboot_day18_01_security.entities.UserEntity;
import com.example.module_javaspringboot_day18_01_security.repository.IUserRepository;
import com.example.module_javaspringboot_day18_01_security.security.CustomerService;
import com.example.module_javaspringboot_day18_01_security.security.LoginSuccessHandler;
import com.example.module_javaspringboot_day18_01_security.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    @Autowired
    LoginSuccessHandler loginSuccessHandler;
    @Autowired
    IUserRepository iUserRepository;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
    @EventListener(
            classes = InteractiveAuthenticationSuccessEvent.class
    )
    public void authenticationSuccessEvent(InteractiveAuthenticationSuccessEvent event) {
        Authentication auth = event.getAuthentication();
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(
                RequestContextHolder.currentRequestAttributes()))
                .getRequest().getSession();

        CustomerService userEntity = (CustomerService) auth.getPrincipal();
        UserEntity user = iUserRepository.findByUsername(userEntity.getUsername());
        session.setAttribute("user",user);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(1296000);
        http.authorizeRequests()
//                .antMatchers("/", "/home", "/add", "/register-user","/register").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
//                .anyRequest()
//                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
//                    .defaultSuccessUrl("/admin")
                    .successHandler(loginSuccessHandler)
//                    .failureHandler(loginFailedHandler)
                .permitAll()
                .and()
                .logout()
//                    .logoutSuccessUrl("/logout")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");
    }
}
