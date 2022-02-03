package com.danielsoo.blog_daniel.config.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // private final CustomOAuth2UserService customOAuth2UserService;
    //
    // @Override
    // protected void configure(HttpSecurity http) throws Exception{
    //     http
    //             .csrf().disable()
    //             .headers().frameOptions().disable()
    //         .and()
    //             .authorizeRequests().antMatchers().
    // }
}
