package com.tts.ecom.Configurations;

import com.tts.ecom.Services.UserService;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
@Autowired
private UserService userService;
@Autowired
private DataSource dataSource;
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;
 
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
}
 
@Override
protected void configure(HttpSecurity http) throws Exception {
  http
      .authorizeRequests()
          .antMatchers("/cart").authenticated()
          .antMatchers("/charge").authenticated()
          .antMatchers("/console/**").permitAll()
          .antMatchers("/resources/**").permitAll()
      .and().formLogin()
          .loginPage("/signin")
          .loginProcessingUrl("/login")
      .and().logout()
          .logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
          .logoutSuccessUrl("/");
  http.headers().frameOptions().disable();

  
  }
@Override
public void configure(WebSecurity web) throws Exception {
    web
            .ignoring()
            .antMatchers("/console/**","/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
}
@Autowired
public DataSource getDataSource() {
	return dataSource;
}

public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
}
}   