package com.concesionario.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
class WebSecurityConfig {

	@Autowired
	JWTAuthorizationFilter jwtAuthorizationFilter;

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception { 
		http
				.csrf((csrf) -> csrf.disable())
				.authorizeHttpRequests(authz -> authz
						.requestMatchers("/swagger-ui/**", "/swagger-ui.html**", "/swagger-resources/**", "/v3/api-docs/**", "/webjars/**").permitAll()
						.requestMatchers("/api/v1/brands/**", "/api/v1/models/**", "/api/v1/search/**", "/api/v1/register",
						 "/api/v1/login/**", "/api/v1/packages/**", "/api/v1/packages/model/**", "/api/v1/engines/**", "/api/v1/engines/model/**",
						 "/api/v1/extcolors/**", "/api/v1/intcolors/**", "/api/v1/tires/**","/api/v1/tires/pack/**","/api/v1/search/**","/api/v1/extcolor/model/**","/api/v1/intcolor/model/**",
						  "/api/v1/brands/new","/api/v1/car/new","/api/v1/car/**" ,"/api/v1/car/user/**", "/api/v1/upload", 
						 "/api/v1/packages/new","/api/v1/extcolors/new","/api/v1/appoinments/**","/api/v1/appoinments/new","/api/v1/models/{id}/status", "/api/v1/password/**",
						 "/api/v1/messages/**", "/api/v1/conversations", "/api/v1/conversations/**", "/api/v1/frequentQuestions/**").permitAll()
						.requestMatchers(HttpMethod.GET, Constans.LOGIN_URL, "/api/v1/images/**").permitAll()
						.anyRequest().denyAll())
				.addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
				.cors(cors -> cors.disable());
		return http.build();
	}
}