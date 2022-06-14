package com.nirsa.nw.web.app.enlacemiddleware.models.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class NwiCabIntegracionSapDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idcabintegracionsap;

	private Integer empresa;

	private String planta;

	private String tipoproceso;

	private String ordenferthalb;

	private String tipomovimiento;

	private String tipomaterial;

	private Date fechaproduccion;

	private Integer idturno;

	private List<String> jsontext;

	private Integer estado;

	private Date fecharegistro;

	private String usuarioregistra;

	private Date fechamodifica;

	private String usuariomodifica;
	
	private List<NwiDetIntegracionSapDTO> listaDetalle;

	public NwiCabIntegracionSapDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NwiCabIntegracionSapDTO(Long idcabintegracionsap, Integer empresa, String planta, String tipoproceso,
			String ordenferthalb, String tipomovimiento, String tipomaterial, Date fechaproduccion, Integer idturno,
			List<String> jsontext, Integer estado, Date fecharegistro, String usuarioregistra, Date fechamodifica,
			String usuariomodifica) {
		super();
		this.idcabintegracionsap = idcabintegracionsap;
		this.empresa = empresa;
		this.planta = planta;
		this.tipoproceso = tipoproceso;
		this.ordenferthalb = ordenferthalb;
		this.tipomovimiento = tipomovimiento;
		this.tipomaterial = tipomaterial;
		this.fechaproduccion = fechaproduccion;
		this.idturno = idturno;
		this.jsontext = jsontext;
		this.estado = estado;
		this.fecharegistro = fecharegistro;
		this.usuarioregistra = usuarioregistra;
		this.fechamodifica = fechamodifica;
		this.usuariomodifica = usuariomodifica;
	}

	public Long getIdcabintegracionsap() {
		return idcabintegracionsap;
	}

	public void setIdcabintegracionsap(Long idcabintegracionsap) {
		this.idcabintegracionsap = idcabintegracionsap;
	}

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	public String getTipoproceso() {
		return tipoproceso;
	}

	public void setTipoproceso(String tipoproceso) {
		this.tipoproceso = tipoproceso;
	}

	public String getOrdenferthalb() {
		return ordenferthalb;
	}

	public void setOrdenferthalb(String ordenferthalb) {
		this.ordenferthalb = ordenferthalb;
	}

	public String getTipomovimiento() {
		return tipomovimiento;
	}

	public void setTipomovimiento(String tipomovimiento) {
		this.tipomovimiento = tipomovimiento;
	}

	public String getTipomaterial() {
		return tipomaterial;
	}

	public void setTipomaterial(String tipomaterial) {
		this.tipomaterial = tipomaterial;
	}

	public Date getFechaproduccion() {
		return fechaproduccion;
	}

	public void setFechaproduccion(Date fechaproduccion) {
		this.fechaproduccion = fechaproduccion;
	}

	public Integer getIdturno() {
		return idturno;
	}

	public void setIdturno(Integer idturno) {
		this.idturno = idturno;
	}

	public List<String> getJsontext() {
		return jsontext;
	}

	public void setJsontext(List<String> jsontext) {
		this.jsontext = jsontext;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
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

	public List<NwiDetIntegracionSapDTO> getListaDetalle() {
		return listaDetalle;
	}

	public void setListaDetalle(List<NwiDetIntegracionSapDTO> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}
	
	

}
