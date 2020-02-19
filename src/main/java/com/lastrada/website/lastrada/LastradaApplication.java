package com.lastrada.website.lastrada;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@ComponentScan({ "com.lastrada.website.lastrada.*" })
@SpringBootApplication
public class LastradaApplication  extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(LastradaApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	@Autowired
	DataSource dataSource;
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
	  throws Exception {
	    auth.jdbcAuthentication()
	      .dataSource(dataSource)
	      .usersByUsernameQuery("select username,password from credentials");
	}
	
	@Override
    protected void configure(HttpSecurity httpSecurity)
    	      throws Exception {
		httpSecurity.authorizeRequests(authorizeRequests ->
		authorizeRequests
         .antMatchers("/allitems","/saveOrder").permitAll()
         .antMatchers("/control/**").access("isAuthenticated()")
         .anyRequest().authenticated());
    	    
	}
	
	
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**");
	    }
}
