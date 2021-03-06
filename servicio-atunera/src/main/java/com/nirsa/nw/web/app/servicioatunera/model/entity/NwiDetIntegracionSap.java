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
@Table(name = "nwi_det_integracion_sap_atunera")
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class),
		@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })

public class NwiDetIntegracionSap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddetintegracionsap;

	@OneToOne
	@JoinColumn(name = "idcabintegracionsap")
	private NwiCabIntegracionSap nwicabintegracionsap;

	@Type(type = "jsonb")
	@Column(columnDefinition = "json")
	private Map<String, Object> jsonenviosap;

	@Type(type = "jsonb")
	@Column(columnDefinition = "json")
	private Map<String, Object> jsonrespuestasap;

	private Integer estadoenviosap;

	private Integer estadorespuestasap;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fecharegistro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_respuesta")
	private Date fecharespuesta;

	@Column(name="usuario_registra")
	private String usuarioregistra;

	@Column(name="fecha_modifica")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechamodifica;

	@Column(name="usuario_modifica")
	private String usuariomodifica;

	public NwiDetIntegracionSap() {
		super();
		// TODO Auto-generated constructor stub
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

	public Long getIddetintegracionsap() {
		return iddetintegracionsap;
	}

	public void setIddetintegracionsap(Long iddetintegracionsap) {
		this.iddetintegracionsap = iddetintegracionsap;
	}

	public NwiCabIntegracionSap getNwicabintegracionsap() {
		return nwicabintegracionsap;
	}

	public void setNwicabintegracionsap(NwiCabIntegracionSap nwicabintegracionsap) {
		this.nwicabintegracionsap = nwicabintegracionsap;
	}

	public Map<String, Object> getJsonenviosap() {
		return jsonenviosap;
	}

	public void setJsonenviosap(Map<String, Object> jsonenviosap) {
		this.jsonenviosap = jsonenviosap;
	}

	public Map<String, Object> getJsonrespuestasap() {
		return jsonrespuestasap;
	}

	public void setJsonrespuestasap(Map<String, Object> jsonrespuestasap) {
		this.jsonrespuestasap = jsonrespuestasap;
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

	public Date getFecharespuesta() {
		return fecharespuesta;
	}

	public void setFecharespuesta(Date fecharespuesta) {
		this.fecharespuesta = fecharespuesta;
	}

}
