package com.nirsa.nw.web.app.enlacemiddleware.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nirsa.nw.web.app.enlacemiddleware.utils.ValoresConstantes;

@Service
public class SapServiceImpl implements ISapService {

	@Autowired
	private RestTemplate middlewareRest;

	@Async
	@Override
	public Map<String,Object> recibir(List<Map<String,Object>> responseSap) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<List<Map<String,Object>>> entity = new HttpEntity<List<Map<String,Object>>>(responseSap, headers);
		Map<String,Object> response = new HashMap<>();
		
		
		try {
			middlewareRest.exchange(ValoresConstantes.urlAtunera, HttpMethod.POST, entity, Map.class).getBody();
		}
		catch(Exception ex) {
			response.put("mensaje", ex.getMessage());
		}
		response.put("mensaje", "Respuesta recibida con éxito");
		return response;
	}

	@Override
	public Map<String,Object> enviarCreacionOrden(Map<String,Object> envioSap) {
				
		middlewareRest = new RestTemplateBuilder()
	                .basicAuthentication(ValoresConstantes.userSap, ValoresConstantes.claveSap)
	                .build();
	
		HttpEntity<Map<String,Object>> entity = new HttpEntity<Map<String,Object>>(envioSap);
		
		System.out.println("ENVIAR ORDEN");
		
		@SuppressWarnings("unchecked")
		Map<String,Object> resp = middlewareRest.exchange(ValoresConstantes.urlEnlace.concat("CreacionOrdenProd"), HttpMethod.POST, entity, Map.class).getBody();
		
		return resp;
		
	}

	@Override
	public Map<String, Object> enviarNotificacion(Map<String, Object> envio) {
		
		middlewareRest = new RestTemplateBuilder()
                .basicAuthentication(ValoresConstantes.userSap, ValoresConstantes.claveSap)
                .build();
		
			HttpEntity<Map<String,Object>> entity = new HttpEntity<Map<String,Object>>(envio);
			
			@SuppressWarnings("unchecked")
			Map<String,Object> resp = middlewareRest.exchange(ValoresConstantes.urlEnlace.concat("CreaNotificacion"), HttpMethod.POST, entity, Map.class).getBody();
			
			return resp;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> enviarEmpacadora(Map<String, Object> envio,String tipo_envio) {
		middlewareRest = new RestTemplateBuilder()
                .basicAuthentication(ValoresConstantes.userSap, ValoresConstantes.claveSap)
                .build();
		
			String endpoint = "";
			Map<String,Object> resp = new HashMap<>();
		
			switch(tipo_envio) {
				case "NO":
					endpoint = "CreaNotificacion";
					break;
				case "EM":
					endpoint = "EntradaMercancias";
					break;
				case "OF":
					endpoint = "CreaOrdenCompra";
					break;
				default:
					endpoint = "CreaOrdenCompra";

					break;
			}
			
			HttpEntity<Map<String,Object>> entity = new HttpEntity<Map<String,Object>>(envio);
			
			if(!endpoint.isEmpty()) {
				resp = middlewareRest.exchange(ValoresConstantes.urlEnlace.concat(endpoint), HttpMethod.POST, entity, Map.class).getBody();

			}
			resp.put("mensaje", "Tipo de integración no permitida");
			
			
			return resp;
		
	}

}
