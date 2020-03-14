package com.lastrada.website.lastrada;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class SecurityJWTReqFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	List<String> allowedURLsWithoutSecurityCheck=new ArrayList<>();
	
	{
		allowedURLsWithoutSecurityCheck.add("/Lastrada/allitems");
		allowedURLsWithoutSecurityCheck.add("/Lastrada/saveOrder");
		allowedURLsWithoutSecurityCheck.add("/Lastrada/getWebsiteStatus");
	}
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authorizationHeader = request.getHeader("Authorization");
		String username = null;
		String jwt = null;
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ") && !isURLAllowedWithoutSecurityCheck(request.getRequestURI())) {
			jwt = authorizationHeader.substring(7);
			username = jwtUtil.extractUsername(jwt);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
			if (jwtUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}
	
	private boolean isURLAllowedWithoutSecurityCheck(String currentURI) {
		for(String currentURLInList:this.allowedURLsWithoutSecurityCheck) {
			if(currentURLInList.contains(currentURI)) {
				return true;
			}
		}
		return false;
	}

	


	
}
