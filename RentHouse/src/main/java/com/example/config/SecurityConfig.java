package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/public").permitAll()
                .antMatchers(HttpMethod.POST, "public").permitAll()
                .antMatchers("/user").hasAnyAuthority("read", "write")
                .antMatchers("/admin").hasAuthority("write")
                .antMatchers("/private").authenticated()
                .and()
                .formLogin()
                .loginPage("/public")
                .loginProcessingUrl("/myLogin")
                .usernameParameter("userlogin")
                .passwordParameter("userpass")
                .successHandler((request, response, authentication) -> {
                    response.sendRedirect("/private");
                })
                .failureHandler((request, response, exception) -> {
                    response.sendRedirect(("/public"));
                }).permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((request, response, authentication) -> {
                    request.getSession().invalidate();
                    response.sendRedirect("/public");
                })
                .and();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

    }
}
