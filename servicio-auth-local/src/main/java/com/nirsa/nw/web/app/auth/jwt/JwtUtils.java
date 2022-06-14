package com.nirsa.nw.web.app.auth.jwt;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.nirsa.nw.web.app.auth.security.services.UserDetailsImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	
	@Autowired
	PasswordEncoder encoder;
	
	@Value("${nirsa.nw.web.app.jwtSecret}")
	private String jwtSecret;

	@Value("${nirsa.nw.web.app.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	@SuppressWarnings("deprecation")
	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
		int tiempoExpiracion = jwtExpirationMs;
	
		
		return Jwts.builder()
				.setSubject((user.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + tiempoExpiracion))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}


}
