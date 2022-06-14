package com.nirsa.nw.web.app.auth.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nirsa.nw.web.app.auth.jwt.JwtUtils;
import com.nirsa.nw.web.app.auth.models.dao.IUsuarioDao;
import com.nirsa.nw.web.app.auth.models.entity.JwtResponse;
import com.nirsa.nw.web.app.auth.models.entity.LoginSolicitud;
import com.nirsa.nw.web.app.auth.models.entity.User;
import com.nirsa.nw.web.app.auth.security.services.UserDetailsImpl;
import com.nirsa.nw.web.app.auth.security.services.UtilService;

@RestController
public class AuthController {
	
	private static Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	IUsuarioDao userDao;
	
	@Autowired 
	AuthenticationManager authenticationManager;	
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UtilService utilService;
	
	@Value("${nirsa.nw.web.app.secretPassword}")
	private String secretPassword;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginSolicitud loginSolicitud ){
			
		utilService.encriptarClave(loginSolicitud.getIdusuario());
		
		String clave_final = loginSolicitud.getIdusuario().concat(loginSolicitud.getClave()).concat(secretPassword);	
		encoder.encode(clave_final);
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginSolicitud.getIdusuario(), clave_final));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		
		return ResponseEntity.ok(new JwtResponse(jwt,userDetails.getIdusuario()));
	}
	
}
