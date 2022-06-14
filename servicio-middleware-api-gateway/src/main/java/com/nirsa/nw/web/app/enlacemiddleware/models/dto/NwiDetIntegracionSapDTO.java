package com.nirsa.nw.web.app.enlacemiddleware.models.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class NwiDetIntegracionSapDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long iddetintegracionsap;
	
	private NwiCabIntegracionSapDTO nwicabintegracionsap;
	
	private List<String> jsonEnvioSap;

	private List<String> jsonrespuestasap;
	
	private Date fecharespuesta;

	private Integer estadoenviosap;
	
	private Integer estadorespuestasap;
	
	private Date fecharegistro;
	
	private String usuarioregistra;
	
	private Date fechamodifica;

	private String usuariomodifica;

	public NwiDetIntegracionSapDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NwiDetIntegracionSapDTO(Long iddetintegracionsap, NwiCabIntegracionSapDTO nwicabintegracionsap,
			List<String> jsonEnvioSap, List<String> jsonrespuestasap, Date fecharespuesta, Integer estadoenviosap,
			Integer estadorespuestasap, Date fecharegistro, String usuarioregistra, Date fechamodifica,
			String usuariomodifica) {
		super();
		this.iddetintegracionsap = iddetintegracionsap;
		this.nwicabintegracionsap = nwicabintegracionsap;
		this.jsonEnvioSap = jsonEnvioSap;
		this.jsonrespuestasap = jsonrespuestasap;
		this.fecharespuesta = fecharespuesta;
		this.estadoenviosap = estadoenviosap;
		this.estadorespuestasap = estadorespuestasap;
		this.fecharegistro = fecharegistro;
		this.usuarioregistra = usuarioregistra;
		this.fechamodifica = fechamodifica;
		this.usuariomodifica = usuariomodifica;
	}

	public Long getIddetintegracionsap() {
		return iddetintegracionsap;
	}

	public void setIddetintegracionsap(Long iddetintegracionsap) {
		this.iddetintegracionsap = iddetintegracionsap;
	}

	public NwiCabIntegracionSapDTO getNwicabintegracionsap() {
		return nwicabintegracionsap;
	}

	public void setNwicabintegracionsap(NwiCabIntegracionSapDTO nwicabintegracionsap) {
		this.nwicabintegracionsap = nwicabintegracionsap;
	}

	public List<String> getJsonEnvioSap() {
		return jsonEnvioSap;
	}

	public void setJsonEnvioSap(List<String> jsonEnvioSap) {
		this.jsonEnvioSap = jsonEnvioSap;
	}

	public List<String> getJsonrespuestasap() {
		return jsonrespuestasap;
	}

	public void setJsonrespuestasap(List<String> jsonrespuestasap) {
		this.jsonrespuestasap = jsonrespuestasap;
	}

	public Date getFecharespuesta() {
		return fecharespuesta;
	}

	public void setFecharespuesta(Date fecharespuesta) {
		this.fecharespuesta = fecharespuesta;
	}

	public Integer getEstadoenviosap() {
		return estadoenviosap;
	}

	public void setEstadoenviosap(Integer estadoenviosap) {
		this.estadoenviosap = estadoenviosap;
	}

	public Integer getEstadorespuestasap() {
		return estadorespuestasap;
	}

	public void setEstadorespuestasap(Integer estadorespuestasap) {
		this.estadorespuestasap = estadorespuestasap;
	}

	public Date getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getUsuarioregistra() {
		return usuarioregistra;
	}

	public void setUsuarioregistra(String usuarioregistra) {
		this.usuarioregistra = usuarioregistra;
	}

	public Date getFechamodifica() {
		return fechamodifica;
	}

	public void setFechamodifica(Date fechamodifica) {
		this.fechamodifica = fechamodifica;
	}

	public String getUsuariomodifica() {
		return usuariomodifica;
	}

	public void setUsuariomodifica(String usuariomodifica) {
		this.usuariomodifica = usuariomodifica;
	}
	
	

}
