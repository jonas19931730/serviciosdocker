package com.nirsa.nw.web.app.servicioatunera.model.services;

import java.util.List;

import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiCabIntegracionSap;

public interface INwiCabIntegracionSapService {
	
	public NwiCabIntegracionSap findById(Long id); 

	public List<NwiCabIntegracionSap> listar();

	public NwiCabIntegracionSap guardar(NwiCabIntegracionSap payload);
	
	public NwiCabIntegracionSap actualizar(NwiCabIntegracionSap payload , Long id);
}
