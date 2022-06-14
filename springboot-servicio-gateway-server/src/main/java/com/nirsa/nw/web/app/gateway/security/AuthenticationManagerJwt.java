package com.nirsa.nw.web.app.gateway.security;

import java.util.Base64;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationManagerJwt implements ReactiveAuthenticationManager{

	@Value("${config.security.oauth.jwt.key}")
	private String llaveJwt;

	
	@Override
	public Mono<Authentication> authenticate(Authentication authentication) {
		return Mono.just(authentication.getCredentials().toString())
				.map(token -> {
					SecretKey llave = Keys.hmacShaKeyFor(Base64.getEncoder().encode(llaveJwt.getBytes()));
							
					return Jwts
							.parserBuilder()
							.setSigningKey(llaveJwt)
							.build()
							.parseClaimsJws(token)
							.getBody();
				})
				.map(claims -> {
					String username = claims.get("idusuario", String.class);
					return new UsernamePasswordAuthenticationToken(username, null, null);
					
				});
	}

}
