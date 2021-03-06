package com.nirsa.nw.web.app.servicioatunera.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

@Entity
@Table(name = "nwi_cab_integracion_sap_atunera")
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class),
		@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
public class NwiCabIntegracionSap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcabintegracionsap;

	private Integer empresa;

	private String planta;

	private String tipoproceso;

	private String ordenferthalb;

	private String tipomovimiento;

	private String tipomaterial;

	@Temporal(TemporalType.DATE)
	private Date fechaproduccion;

	private Integer turno;

	@Type(type = "jsonb")
	@Column(columnDefinition = "json")
	private Map<String, Object> jsontext;

	private Integer estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_registro;

	private String usuario_registra;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modifica")
	private Date fechamodifica;

	@OneToOne
	@JoinColumn(name = "iddetintegracionsap")
	private NwiDetIntegracionSap nwiDetalle;

	@Column(name="usuario_modifica")
	private String usuariomodifica;

	public NwiCabIntegracionSap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Map<String, Object> getJsontext() {
		return jsontext;
	}

	public void setJsontext(Map<String, Object> jsontext) {
		this.jsontext = jsontext;
	}

	public NwiDetIntegracionSap getNwiDetalle() {
		return nwiDetalle;
	}

	public void setNwiDetalle(NwiDetIntegracionSap nwiDetalle) {
		this.nwiDetalle = nwiDetalle;
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

	public Integer getTurno() {
		return turno;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getUsuario_registra() {
		return usuario_registra;
	}

	public void setUsuario_registra(String usuario_registra) {
		this.usuario_registra = usuario_registra;
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
