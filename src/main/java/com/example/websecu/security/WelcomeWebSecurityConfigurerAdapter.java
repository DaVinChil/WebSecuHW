package com.example.websecu.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WelcomeWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}1234")
                .authorities("BASIC_USER")
                .and()
                .withUser("admin")
                .password("{noop}admin")
                .authorities("ADMIN", "BASIC_USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/welcome").permitAll()
                .and()
                .authorizeRequests().antMatchers("/elite-welcome").hasAuthority("BASIC_USER")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
