package com.charge.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin")
            .password("{noop}admin")
            .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers("/admin/product/**")
            .hasRole("ADMIN")
            .and()
            .csrf()
            .disable()
            .formLogin()
            .disable();
    }


}
