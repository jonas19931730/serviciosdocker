package com.nirsa.nw.web.app.servicioatunera.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "log_transaccion_sap")
public class LogTransaccionSap implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String idSap;

	@Column(name = "idusuario")
	private String idUsuario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_enviado")
	private Date fechaEnviado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_recibido")
	private Date fechaRecibido;

	public LogTransaccionSap() {
		super();
	}

	public LogTransaccionSap(Long id, String idSap, String idUsuario, Date fechaEnviado, Date fechaRecibido) {
		super();
		this.id = id;
		this.idSap = idSap;
		this.idUsuario = idUsuario;
		this.fechaEnviado = fechaEnviado;
		this.fechaRecibido = fechaRecibido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdSap() {
		return idSap;
	}

	public void setIdSap(String idSap) {
		this.idSap = idSap;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFechaEnviado() {
		return fechaEnviado;
	}

	public void setFechaEnviado(Date fechaEnviado) {
		this.fechaEnviado = fechaEnviado;
	}

	public Date getFechaRecibido() {
		return fechaRecibido;
	}

	public void setFechaRecibido(Date fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}
	private static final long serialVersionUID = 1L;

}
