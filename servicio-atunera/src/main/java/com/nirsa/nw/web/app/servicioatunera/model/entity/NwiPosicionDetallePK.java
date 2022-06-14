package com.nirsa.nw.web.app.servicioatunera.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class NwiPosicionDetallePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "idcabintegracionsap")
	private NwiCabIntegracionSap nwicabintegracionsap;

	@ManyToOne
	@JoinColumn(name = "id_control")
	private NwiCabControl nwicabcontrol;

	private Integer idposicion;

	public NwiPosicionDetallePK() {

	}

	public NwiPosicionDetallePK(NwiCabIntegracionSap nwicabintegracionsap, Integer idposicion) {
		super();
		this.nwicabintegracionsap = nwicabintegracionsap;
		this.idposicion = idposicion;
	}

	public NwiCabIntegracionSap getNwicabintegracionsap() {
		return nwicabintegracionsap;
	}

	public void setNwicabintegracionsap(NwiCabIntegracionSap nwicabintegracionsap) {
		this.nwicabintegracionsap = nwicabintegracionsap;
	}

	public Integer getIdposicion() {
		return idposicion;
	}

	public void setIdposicion(Integer idposicion) {
		this.idposicion = idposicion;
	}

	public NwiCabControl getNwicabcontrol() {
		return nwicabcontrol;
	}

	public void setNwicabcontrol(NwiCabControl nwicabcontrol) {
		this.nwicabcontrol = nwicabcontrol;
	}

}
