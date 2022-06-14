package com.nirsa.nw.web.app.servicioatunera.calidad.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "calidad_catalogo_esterilizado_novedad")
public class CalidadCatalogoEsterilizadoNovedad implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcalidadcatalogoesterilizadonovedad;
	
	private Integer estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecharegistro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechamodificacion;

	private String idusuarioregistro;
	private String idusuariomodificacion;

	private String codigo;

	private String descripcion;
	
	public CalidadCatalogoEsterilizadoNovedad() {
	}

	public CalidadCatalogoEsterilizadoNovedad(Long idcalidadcatalogoesterilizadonovedad, Integer estado,
			Timestamp fecharegistro, Timestamp fechamodificacion, String idusuarioregistro,
			String idusuariomodificacion, String codigo, String descripcion) {
		this.idcalidadcatalogoesterilizadonovedad = idcalidadcatalogoesterilizadonovedad;
		this.estado = estado;
		this.fecharegistro = fecharegistro;
		this.fechamodificacion = fechamodificacion;
		this.idusuarioregistro = idusuarioregistro;
		this.idusuariomodificacion = idusuariomodificacion;
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public Long getIdcalidadcatalogoesterilizadonovedad() {
		return idcalidadcatalogoesterilizadonovedad;
	}

	public void setIdcalidadcatalogoesterilizadonovedad(Long idcalidadcatalogoesterilizadonovedad) {
		this.idcalidadcatalogoesterilizadonovedad = idcalidadcatalogoesterilizadonovedad;
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

	public Date getFechamodificacion() {
		return fechamodificacion;
	}

	public void setFechamodificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}

	public String getIdusuarioregistro() {
		return idusuarioregistro;
	}

	public void setIdusuarioregistro(String idusuarioregistro) {
		this.idusuarioregistro = idusuarioregistro;
	}

	public String getIdusuariomodificacion() {
		return idusuariomodificacion;
	}

	public void setIdusuariomodificacion(String idusuariomodificacion) {
		this.idusuariomodificacion = idusuariomodificacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private static final long serialVersionUID = 1L;

}
