package com.inf.khproject.config;

import com.inf.khproject.security.handler.MemberHandler;
import com.inf.khproject.security.service.CustomMemberDetailService;
import com.inf.khproject.security.service.PrincipalDetails;
import com.inf.khproject.security.service.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
@Log4j2
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomMemberDetailService CustomMemberDetailService;
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    private final PrincipalDetails principalDetails;
    private final PrincipalOauth2UserService principalOauth2UserService;
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails user = User.builder()
//                .username("user1")
//                .password(passwordEncoder().encode("1111"))
//                .roles("USER")
//                .build();
//
//        log.info("userDetailesService............");
//        log.info(user);
//
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .antMatchers("/resources/**", "/error", "/favicon.ico");
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.csrf().disable()
                .headers().frameOptions().disable()
            .and().authorizeHttpRequests()
                .antMatchers("/member/**", "/").permitAll()
                .antMatchers("/applicationboard/register").hasAnyRole("INDIVIDUAL", "ADMIN")
                .antMatchers("/applicationboard/list").permitAll()
                .antMatchers("/applicationboard/read").authenticated()
                .antMatchers("/interiorboard/register").hasAnyRole("COMPANY", "ADMIN")
                .antMatchers("/interiorboard/**").permitAll()
                .antMatchers("/service-center/notice/register","/service-center/notice/modify","/service-center/notice/remove").hasRole("ADMIN")
                .antMatchers("/service-center/qna/**").authenticated()
                .antMatchers("/service-center/**").permitAll()
            .and().formLogin()
                .loginPage("/member/login")
                .defaultSuccessUrl("/")
                .failureHandler(customAuthenticationFailureHandler)
                .usernameParameter("username")
                .passwordParameter("pw")
            .and().logout().logoutUrl("/member/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
            .and().rememberMe()
                .rememberMeParameter("remember")
                .tokenValiditySeconds(3600)
                .userDetailsService(CustomMemberDetailService)
            .and().oauth2Login()
                .defaultSuccessUrl("/")
                .userInfoEndpoint()
                .userService(principalOauth2UserService);
            



        return http.build();
    }


//    @Bean
//    public UserDetailsManager users(DataSource dataSource) {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("username")
//                .password("pw")
//                .roles("INDIVIDUAL")
//                .build();
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        users.createUser(user);
//        return users;
//    }

    @Bean
    public MemberHandler successHandler() {
        return new MemberHandler(passwordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
