package com.nirsa.nw.web.app.servicioatunera.calidad.model.services;

import java.util.List;

import com.nirsa.nw.web.app.servicioatunera.calidad.model.entity.CalidadCatalogoEsterilizadoNovedad;
import com.nirsa.nw.web.app.servicioatunera.model.entity.ResponseSap;

public interface ICalidadCatalogoEsterilizadoNovedadService {
	
	public List<CalidadCatalogoEsterilizadoNovedad> listar();
	
	public CalidadCatalogoEsterilizadoNovedad findById(Integer id);
	
	public CalidadCatalogoEsterilizadoNovedad guardar(CalidadCatalogoEsterilizadoNovedad payload);
	
	public ResponseSap enviarSap(CalidadCatalogoEsterilizadoNovedad payload,String idusuario);
	
	public CalidadCatalogoEsterilizadoNovedad actualizar(Integer id,CalidadCatalogoEsterilizadoNovedad payload);
	
	public void eliminar(Integer id);
	
}
