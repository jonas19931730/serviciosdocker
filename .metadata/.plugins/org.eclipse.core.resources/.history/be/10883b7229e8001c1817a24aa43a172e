package com.nirsa.nw.web.app.servicioatunera.model.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

@Entity
@Table(name = "nwi_cab_control")
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class),
		@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
public class NwiCabControl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_control")
	private Long idControl;

	@Type(type = "jsonb")
	@Column(columnDefinition = "json")
	private Map<String, Object> jsonBusqueda;

	private Long idintegracion;

	public NwiCabControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NwiCabControl(Long idControl, Map<String, Object> jsonBusqueda, Long idintegracion) {
		super();
		this.idControl = idControl;
		this.jsonBusqueda = jsonBusqueda;
		this.idintegracion = idintegracion;
	}

	public Long getIdControl() {
		return idControl;
	}

	public void setIdControl(Long idControl) {
		this.idControl = idControl;
	}

	public Map<String, Object> getJsonBusqueda() {
		return jsonBusqueda;
	}

	public void setJsonBusqueda(Map<String, Object> jsonBusqueda) {
		this.jsonBusqueda = jsonBusqueda;
	}

	public Long getIdintegracion() {
		return idintegracion;
	}

	public void setIdintegracion(Long idintegracion) {
		this.idintegracion = idintegracion;
	}

}
