package com.nirsa.nw.web.app.enlacemiddleware.services;

import java.util.List;
import java.util.Map;

public interface ISapService {

	public Map<String,Object> enviarCreacionOrden(Map<String,Object> envio);
	
	public Map<String,Object> enviarNotificacion(Map<String,Object> envio);
	
	public Map<String,Object> recibir(List<Map<String,Object>> responseSap);
	
	// empacadora
	public Map<String,Object> enviarEmpacadora(Map<String,Object> envio,String tipo_envio);

	
}
