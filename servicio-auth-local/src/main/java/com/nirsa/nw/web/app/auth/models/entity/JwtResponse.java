package com.nirsa.nw.web.app.auth.models.entity;

public class JwtResponse {
	private String token;
	private String type = "Bearer";

	private String idusuario;

	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtResponse(String token, String idusuario) {
		super();
		this.token = token;
		this.idusuario = idusuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

}
