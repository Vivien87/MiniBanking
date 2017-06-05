package com.vivi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author vivi
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   
    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/HB/**").access("hasRole('USER')")
                .antMatchers("/resources/**").permitAll()
                .and().formLogin()
                    .loginPage("/login").permitAll()
                   // .usernameParameter("username").passwordParameter("password")
                    .defaultSuccessUrl("/HB/index")
                .and().logout().permitAll()
                .and().csrf();
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }

}
