package com.copenned.crm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration
//@EnableWebSecurity

public class AppSecurityConfig   {

//    @Autowired
//    private UserDetailsService userDetailsService;
//    @Bean
//    AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//
//        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder((new BCryptPasswordEncoder()));
//        return provider;
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/api/payment/**").hasAuthority("salesman")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }

    //    @Autowired
//    UserDetailsService userDetailsService;
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //set your configuration on the auth object
//        auth.userDetailsService(userDetailsService);
//        auth.inMemoryAuthentication()
//                .withUser("blah")
//                .password("blah")
//                .roles("USER")
//                .and()
//                .withUser("foo")
//                .password("foo")
//                .roles("ADMIN");

//    }

//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
////                .antMatchers("/payment").hasRole("USER")
////                .antMatchers("/**").hasRole("ADMIN")
//                .antMatchers("/**").permitAll();
//
//
//    }
}