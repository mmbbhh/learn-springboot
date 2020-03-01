package com.day07.day07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root").password("$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq").roles("ADMIN", "DBA")
                .and()
                .withUser("admin").password("$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq").roles("ADMIN","USER")
                .and()
                .withUser("mmbbhh").password("$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //访问admin目录必须有ADMIN权限
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                //访问user目录必须有ADMIN或USER权限
                .antMatchers("/user/**")
                .access("hasAnyRole('ADMIN','USER')")
                //访问DB目录必须有ADMIN和DBA权限
                .antMatchers("/db/**")
                .access("hasRole('ADMIN') and hasRole('DBA')")
                //其他目录必须登陆后才能访问
                .anyRequest()
                .authenticated()
                .and()
                //启用login接口作为登录POST接口
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll()//登录接口无需认证
                .and()
                .csrf()
                .disable();
    }
}
