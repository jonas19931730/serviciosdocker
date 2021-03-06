package com.nirsa.nw.web.app.servicioatunera.model.services;

import java.util.List;

import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiDetIntegracionSap;

public interface INwiDetIntegracionSapService {
	
	public NwiDetIntegracionSap findById(Long id); 

	public List<NwiDetIntegracionSap> listar();
	
	public NwiDetIntegracionSap findByDetalleyCabecera(Long iddetalle,Long idcabecera);

	public NwiDetIntegracionSap guardar(NwiDetIntegracionSap payload);
	
	public NwiDetIntegracionSap actualizar(NwiDetIntegracionSap payload,Long id);
	
	public void actualizarOrdenesFinalizadas(List<NwiDetIntegracionSap> payload);
	
}
