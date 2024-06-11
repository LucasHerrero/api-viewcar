package com.concesionario.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.concesionario.service.UserService;
import com.concesionario.entity.User;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.concesionario.security.Constans.*;

@Configuration
public class JWTAuthtenticationConfig {
    @Autowired
    private UserService userService;

	public String getJWTToken(String username) {
		User user = userService.findByUsername(username);
		String role = user.getRol();
		String name = user.getFirstName(); // Asegúrate de tener un método getName() en tu clase User
		String surname = user.getSecondLastName(); // Asegúrate de tener un método getSurname() en tu clase User
		Number id = user.getId(); // Asegúrate de tener un método getId() en tu clase User
	
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
			.commaSeparatedStringToAuthorityList(role);
	
		String token = Jwts
			.builder()
			.setId("concesionarioJWT")
			.setSubject(username)
			.claim("authorities",
				grantedAuthorities.stream()
					.map(GrantedAuthority::getAuthority)
					.collect(Collectors.toList()))
			.claim("name", name) // Agrega el nombre como una reclamación
			.claim("surname", surname) // Agrega el apellido como una reclamación
			.claim("id", id) // Agrega el ID como una reclamación
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
			.signWith(getSigningKey(SUPER_SECRET_KEY), SignatureAlgorithm.HS512).compact();
	
		return "Bearer " + token;
	}
}