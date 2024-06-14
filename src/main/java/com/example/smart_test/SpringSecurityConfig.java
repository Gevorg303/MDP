package com.example.smart_test;


import com.example.smart_test.security.JwtCsrfFilter;
import com.example.smart_test.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import com.example.smart_test.security.JwtTokenRepository;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig{

    @Autowired
    private UserServiceImpl service;

    @Autowired
    private JwtTokenRepository jwtTokenRepository;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Bean
    public PasswordEncoder devPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // что-то поломалось с настройкой
        http.sessionManagement((session) -> session
                .sessionCreationPolicy(SessionCreationPolicy.NEVER))
                .addFilterAt(new JwtCsrfFilter(jwtTokenRepository, resolver), CsrfFilter.class)
                .csrf((csrf) -> csrf
                .ignoringRequestMatchers("/**"))
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/auth/login")
                        .authenticated()
                )
                .httpBasic(c -> c.authenticationEntryPoint(((request, response, e) -> resolver.resolveException(request, response, null, e))));


        return http.build();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.service);
    }

}