package com.loja.produtos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests((authz) -> authz.anyRequest().authenticated() // precisa estar autenticado para
                // realizar qualquer request
        ).formLogin(form ->
                form.loginPage("/login").permitAll()
        ).logout(logout ->
                logout.logoutUrl("/logout")
        );
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
        users(dataSource);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService users(DataSource dataSource){
        UserDetails user = User.builder()
                .username("User1")
                .password(passwordEncoder().encode("pass"))
                .roles("admin")
                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        return users;
    }
}
