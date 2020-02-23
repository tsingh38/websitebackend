package com.lastrada.website.lastrada;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@ComponentScan({ "com.lastrada.website.lastrada.*" })
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class LastradaApplication  extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{
	private final Log logger = LogFactory.getLog(getClass());
	public static void main(String[] args) {
		SpringApplication.run(LastradaApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
		//return NoOpPasswordEncoder.getInstance();
	}

	@Autowired
	DataSource dataSource;
	
	@Autowired
	private AuthExceptionEntryPoint authExceptionEntryPoint;
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
	  throws Exception {
	    auth.jdbcAuthentication()
	      .dataSource(dataSource)
	      .usersByUsernameQuery("select username,password,1 from credentials where username=?")
	      .authoritiesByUsernameQuery("select username,password, 'ROLE_USER' from credentials where username=?");

	}
	
	@Override
    protected void configure(HttpSecurity http)
    	      throws Exception {
		
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
		.antMatchers("/allitems").permitAll()
				 .antMatchers("/getOrders","/validateLogin").fullyAuthenticated().and().formLogin().permitAll()
				 .successHandler(new AuthenticationSuccessHandler() {
					
					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						
					}
				})
				 .and().exceptionHandling().authenticationEntryPoint(authExceptionEntryPoint)
				 .and().httpBasic();
	
		
    	    
	}

	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedOrigins("*");
	    }
}
