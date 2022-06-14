package com.nirsa.nw.web.app.servicioatunera.model.services;

import java.util.List;
import java.util.Map;

import com.nirsa.nw.web.app.servicioatunera.model.dto.RequestMonitor;

public interface ISapService {
	public Map<String,Object> enviar(RequestMonitor request,String tipo_envio);

	public Map<String,Object> recibirSap(List<Map<String,Object>> responseSap);
	
	public Map<String,Object> enviarEmpacadora(Map<String,Object> envio,String tipo_envio);

}
