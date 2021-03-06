package com.nirsa.nw.web.app.servicioatunera.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

@Entity
@Table(name = "nwi_posicion_detalle")
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class),
		@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })

public class NwiPosicionDetalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NwiPosicionDetallePK nwiLineaPk;
	
	@Type(type = "jsonb")
	@Column(name="json_envio_sap",columnDefinition = "json")
	private Map<String, Object> jsonEnvioSap;

	@Type(type = "jsonb")
	@Column(columnDefinition = "json")
	private Map<String, Object> jsonrespuestasap;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecharenvio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecharespuesta;

	private Integer estadoenviosap;

	private Integer estadorespuestasap;

	public NwiPosicionDetalle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NwiPosicionDetallePK getNwiLineaPk() {
		return nwiLineaPk;
	}

	public void setNwiLineaPk(NwiPosicionDetallePK nwiLineaPk) {
		this.nwiLineaPk = nwiLineaPk;
	}

	public Map<String, Object> getJsonEnvioSap() {
		return jsonEnvioSap;
	}

	public void setJsonEnvioSap(Map<String, Object> jsonEnvioSap) {
		this.jsonEnvioSap = jsonEnvioSap;
	}

	public Map<String, Object> getJsonrespuestasap() {
		return jsonrespuestasap;
	}

	public void setJsonrespuestasap(Map<String, Object> jsonrespuestasap) {
		this.jsonrespuestasap = jsonrespuestasap;
	}

	public Date getFecharenvio() {
		return fecharenvio;
	}

	public void setFecharenvio(Date fecharenvio) {
		this.fecharenvio = fecharenvio;
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

}
