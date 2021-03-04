package io.github.tambonbon.musicappspring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter { //https://spring.io/guides/topicals/spring-security-architecture
    // Authentication
    @Override // Override only build a local AuthenticationManager
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("werner")
                .password("{noop}pass")
                .roles("USER")
                .and()
                .withUser("daniel")
                .password(passwordEncoder().encode("daniel"))
                .roles("USER") ;
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Authorize
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/")
                    .permitAll() // allow all at home page
                .antMatchers("/img/**")
                    .permitAll() // allow all to access static imgs
                .antMatchers("/public**")
                    .permitAll() // making login directory on classpath root available without authentication
                .antMatchers("/albums/**").permitAll()
                .anyRequest()
                    .authenticated()// authenticate everything else
                .and()
                .formLogin();
//                .loginPage("/login.html")
//                .failureUrl("/login-error.html")
//                .permitAll();
    }
//    @Override
//    public void configure(HttpSecurity http) throws Exception  {
//        http
////                .csrf().disable()
//                .authorizeRequests()
////                .antMatchers("/admin/**").hasRole("ADMIN")
////                .antMatchers("/anonymous*").anonymous()
////                .antMatchers("/login*").permitAll() // making login directory on classpath root available without authentication
//                .antMatchers("/public**").permitAll() // making login directory on classpath root available without authentication
//                .antMatchers("/html**").permitAll() // making login directory on classpath root available without authentication
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login.html")
//                .failureUrl("/login-error.html")
//                .permitAll();
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/homepage.html", true)
//                .failureUrl("/login.html?error=true")
//                .failureHandler(new AuthenticationFailureHandler() {
//                    @Override
//                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//                        String email = httpServletRequest.getParameter("email");
//                        String error = e.getMessage();
//                        System.out.println("A failed login attempt with email: "
//                                + email + ". Reason: " + error);
//
//                        String redirectUrl = httpServletRequest.getContextPath() + "/login?error";
//                        httpServletResponse.sendRedirect(redirectUrl);
//                    }
//                })
//                .and()
//                .logout()
//                .logoutUrl("/perform_logout")
//                .deleteCookies("JSESSIONID");
//    }
}
