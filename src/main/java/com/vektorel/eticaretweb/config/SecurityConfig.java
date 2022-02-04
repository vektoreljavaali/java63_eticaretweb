package com.vektorel.eticaretweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/",
                        "/index","/index.html","/login","/register",
                        "/**")
                .permitAll()
                .anyRequest().authenticated();

        // Post,Put gibi isteklerin security tarafından engellenmemesi
        // için bu ayarın yapılması gereklidir. aksi takdirde hata fırlatır.
        http.cors().and().csrf().disable();



    }
}
