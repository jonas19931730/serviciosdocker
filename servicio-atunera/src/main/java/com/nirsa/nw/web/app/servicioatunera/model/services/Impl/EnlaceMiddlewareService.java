package com.nirsa.nw.web.app.servicioatunera.model.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nirsa.nw.web.app.servicioatunera.model.services.IEnlaceMiddlewareSap;
import com.nirsa.nw.web.app.servicioatunera.utils.ValoresConstantes;
import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiDetIntegracionSap;

@Service
public class EnlaceMiddlewareService implements IEnlaceMiddlewareSap {

	@Autowired
	RestTemplate conexionEnlace;

	@Override
	public Object enviarProceso(List<NwiDetIntegracionSap> request) {
		return conexionEnlace.postForObject(ValoresConstantes.urlMiddleware, request, Object.class);
	}

}
