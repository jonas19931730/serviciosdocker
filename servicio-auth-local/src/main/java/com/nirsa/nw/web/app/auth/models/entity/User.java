package com.nirsa.nw.web.app.auth.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String idusuario;

	@Column(name = "clave_encriptada", length = 120)
	private String password;

	private String clave;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String idusuario, String password) {
		super();
		this.idusuario = idusuario;
		this.password = password;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return this.getIdusuario().concat(" ").concat(this.getPassword());
	}

}
