package com.nirsa.nw.web.app.servicioatunera.model.services;

import java.util.List;

import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiDetIntegracionSap;

public interface IEnlaceMiddlewareSap {
	
	
	public Object enviarProceso(List<NwiDetIntegracionSap> request);
}
