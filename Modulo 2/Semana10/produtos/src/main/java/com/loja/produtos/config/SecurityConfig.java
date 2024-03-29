package com.loja.produtos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((authz) ->
                        authz.requestMatchers("/","/login").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(login ->
                    login.loginPage("/login")
                            .defaultSuccessUrl("/produto/all", true)
                            .permitAll()
                )
                .logout(logout ->
                    logout.logoutUrl("logout").permitAll()
                );
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService users(DataSource dataSource){
        UserDetails user = User.builder()
                .username("user1")
                .password(passwordEncoder().encode("pass"))
                .roles("admin")
                .build();
        JdbcUserDetailsManager newUser = new JdbcUserDetailsManager(dataSource);
        newUser.createUser(user);
//        return new InMemoryUserDetailsManager(user);
        return newUser;
    }
}
