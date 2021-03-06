package com.nirsa.nw.web.app.servicioatunera.model.entity;

import java.io.Serializable;
import java.util.Map;

public class ResponseSap implements Serializable {

	private Long idintegracion;
	private String codigo_respuesta;
	private String mensaje_error;
	private Map<String, Object> respuestaSap;

	public ResponseSap() {
	}

	public Long getIdintegracion() {
		return idintegracion;
	}

	public void setIdintegracion(Long idintegracion) {
		this.idintegracion = idintegracion;
	}

	public String getCodigo_respuesta() {
		return codigo_respuesta;
	}

	public void setCodigo_respuesta(String codigo_respuesta) {
		this.codigo_respuesta = codigo_respuesta;
	}

	public String getMensaje_error() {
		return mensaje_error;
	}

	public void setMensaje_error(String mensaje_error) {
		this.mensaje_error = mensaje_error;
	}

	public Map<String, Object> getRespuestaSap() {
		return respuestaSap;
	}

	public void setRespuestaSap(Map<String, Object> respuestaSap) {
		this.respuestaSap = respuestaSap;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
