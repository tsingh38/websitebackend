package com.lastrada.website.lastrada;

import java.util.Arrays;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
	private final Log logger = LogFactory.getLog(getClass());
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
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
		private  MyUserDetailsService myUserDetailsService;
		
		@Autowired
		private SecurityJWTReqFilter jwtRequestFilter;
		
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) 
		  throws Exception {
		  
			auth.userDetailsService(myUserDetailsService);
		}
		
		@Override
	    protected void configure(HttpSecurity http)
	    	      throws Exception {
			http.cors();
			http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
			http.csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
			.antMatchers("/authenticate","/saveOrder","/allitems","/getWebsiteStatus").permitAll().and().authorizeRequests()
					 .anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

	        .and().logout().clearAuthentication(true)
	        .logoutSuccessUrl("/");
			
	    	    
		}
		
		   @Bean
		    public CorsConfigurationSource corsConfigurationSource() {
		        CorsConfiguration configuration = new CorsConfiguration();
		        configuration.setAllowedOrigins(Arrays.asList("*"));
		        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
		        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
		        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		        source.registerCorsConfiguration("/**", configuration);
		        return source;
		    }

		 @Override
		    public void addCorsMappings(CorsRegistry registry) {
		        registry.addMapping("/**").allowedOrigins("*");
		    }
}
