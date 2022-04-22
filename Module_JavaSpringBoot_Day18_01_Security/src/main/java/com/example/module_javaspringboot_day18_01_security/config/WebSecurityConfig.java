package com.example.module_javaspringboot_day18_01_security.config;

import com.example.module_javaspringboot_day18_01_security.security.LoginSuccessHandler;
import com.example.module_javaspringboot_day18_01_security.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
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
                .accessDeniedPage("/403")
                .and()
                .rememberMe()
                .key("haiPhong@9")

        ;
    }
}
