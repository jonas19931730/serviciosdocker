package com.nirsa.nw.web.app.servicioatunera.model.entity;

import java.io.Serializable;
import java.util.Map;

public class RequestSap implements Serializable {

	private Long idintegracion;

	private Map<String, Object> jsonEnvioSap;

	public RequestSap() {

	}

	public Long getIdintegracion() {
		return idintegracion;
	}

	public void setIdintegracion(Long idintegracion) {
		this.idintegracion = idintegracion;
	}

	public Map<String, Object> getJsonEnvioSap() {
		return jsonEnvioSap;
	}

	public void setJsonEnvioSap(Map<String, Object> jsonEnvioSap) {
		this.jsonEnvioSap = jsonEnvioSap;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
