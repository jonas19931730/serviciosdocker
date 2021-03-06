package com.nirsa.nw.web.app.servicioatunera.model.services;

import java.util.Map;

import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiCabControl;
import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiPosicionDetalle;

public interface ICabControlService {
	
	public NwiCabControl buscarPorJson(Map<String,Object> params);
	
	public NwiCabControl registrar(NwiCabControl control);
	
	public Integer getMaximaPosicion(Long idcontrol);
	
	public NwiPosicionDetalle guardarPosicion(NwiPosicionDetalle pd);
}
