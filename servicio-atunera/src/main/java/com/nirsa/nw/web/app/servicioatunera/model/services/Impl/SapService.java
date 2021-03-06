package com.nirsa.nw.web.app.servicioatunera.model.services.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.nirsa.nw.web.app.servicioatunera.model.dto.RequestMonitor;
import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiCabControl;
import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiCabIntegracionSap;
import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiDetIntegracionSap;
import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiPosicionDetalle;
import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiPosicionDetallePK;
import com.nirsa.nw.web.app.servicioatunera.model.services.ICabControlService;
import com.nirsa.nw.web.app.servicioatunera.model.services.INwiCabIntegracionSapService;
import com.nirsa.nw.web.app.servicioatunera.model.services.INwiDetIntegracionSapService;
import com.nirsa.nw.web.app.servicioatunera.model.services.ISapService;
import com.nirsa.nw.web.app.servicioatunera.utils.ValoresConstantes;

@Service
public class SapService implements ISapService {
	
	@Autowired
	INwiCabIntegracionSapService nwiCabService;
	
	@Autowired
	ICabControlService nwiCabControlService;
	
	@Autowired
	INwiDetIntegracionSapService detService;
	
	@Autowired
	RestTemplate conexionEnlace;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Map<String,Object> recibirSap(List<Map<String,Object>> responseSap) {
		
		Map<String,Object> response = new HashMap<>();
		
		try {
			Map<String,Object> item = responseSap.get(0);
			List<Map<String,Object>> detalle = (List<Map<String,Object>>) item.get("DETALLE"); 
			Map<String,Object> respSap = new HashMap<String,Object>();
			
			Set<String> keysValoresJson = item.keySet();
			for ( String key : keysValoresJson ) {
				if(!key.equals("DETALLE")) {
					Object value = item.get(key);
					respSap.put(key, value);				
				}
	        }
			
			Map<String,Object> detalleFinal = new HashMap<>();
			
			for(Map<String,Object> itemDetalle:detalle) {
				Set<String> valoresJson = itemDetalle.keySet();
				for ( String key : valoresJson ) {
					if(!key.equals("RESULTADO")) {
						Object value = item.get(key);
						detalleFinal.put(key, value);				
					}else {
						Map<String,Object> resultados = (Map<String,Object>) itemDetalle.get(key);
						Map<String,Object> result = new HashMap<>();
						Set<String> valoresResultado = resultados.keySet();
						for ( String keyResultado : valoresResultado ) {
							Object value = resultados.get(keyResultado);
							result.put(keyResultado, value);		
						}
						detalleFinal.put(key, result);
					}
		        }
			}
			
			respSap.put("DETALLE", detalle);
			conexionEnlace.postForObject(ValoresConstantes.urlIntegrador, responseSap, Map.class);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return response;
		
	}
	
	//@Async
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Object> enviar(RequestMonitor request,String tipo_envio) {
		Map<String,Object> envioSap = generarJsonSap(request,tipo_envio);
		Map<String,Object> response = new HashMap<>();
		
		Map<String,Object> respSap = new HashMap<>();
		
		if(tipo_envio.equals("NO")) {
			Map<String,Object> jsonGenerado = (Map<String,Object>)envioSap.get("jsonSap");
			Map<String,Object> payloadSap = new HashMap<String,Object>();
			List<Map<String,Object>> arrayJson = new ArrayList<Map<String,Object>>();
			arrayJson.add(jsonGenerado);
			payloadSap.put("NOTIFICACION", arrayJson);
			
			response.put("envio_sap", payloadSap);
			respSap = conexionEnlace.postForObject(ValoresConstantes.urlMiddleware.concat("/enviarNotificacion"), payloadSap, Map.class);
		}
		
		if(tipo_envio.equals("OF")) {
			Map<String,Object> payloadSap = (Map<String,Object>)envioSap.get("jsonSap");
			response.put("envio_sap", payloadSap);

			respSap = conexionEnlace.postForObject(ValoresConstantes.urlMiddleware.concat("/enviarOrden"), payloadSap, Map.class);
		}
		
	
		Long idIntegracion = (Long) envioSap.get("id_integracion");
		//List<Map<String,Object>> detalle = (List<Map<String,Object>>) envioSap.get("detalle");
		
		response.put("id_integracion", idIntegracion);
		//response.put("detalle", detalle);
		
		response.put("respuesta_sap", respSap);
		return response;
	}
	
		
	@SuppressWarnings("unchecked")
	private Map<String,Object> generarJsonSap(RequestMonitor request,String tipo_envio){
		
		Map<String,Object> responseFinal = new HashMap<>();
		Map<String,Object> envioSap = new HashMap<>();
		List<Map<String,Object>> detalleSap = new ArrayList<>();
				
		// conformaci??n de la cabecera del JSON
		Set<String> keys = request.getJsonCabecera().keySet();
		
		for ( String key : keys ) {
			Object value = request.getJsonCabecera().get(key);
			envioSap.put(key.toUpperCase(), value.toString().toUpperCase());	
        }
		
	
		Map<String,Object> response = registrarPosiciones(envioSap,request.getDetalle(),request.getJsonParametrosBusqueda(),tipo_envio);
		
		Long idintegracion = (Long) response.get("id_integracion");
		detalleSap = (List<Map<String,Object>>) response.get("detalles");
		
		envioSap.put("DETALLE", detalleSap);
		envioSap.put("ID_INTEGRACION", "PA".concat(Long.toString(idintegracion).toUpperCase()));
		
		responseFinal.put("jsonSap", envioSap);
	
		responseFinal.put("id_integracion", idintegracion);
		responseFinal.put("detalle", detalleSap);
		
		return responseFinal;
	}
	
	private Map<String,Object> registrarPosiciones(Map<String,Object> jsonGlobal, List<Map<String,Object>> detalles,Map<String,Object> jsonParams,String tipo_envio) {
		
		Map<String,Object> response = new HashMap<>();
		
		List<Map<String,Object>> detalleSap = new ArrayList<>();

		NwiCabControl controlRegistro = null;
		//NwiCabControl control = this.nwiCabControlService.buscarPorJson(jsonParams);
		
		//NwiCabControl control=null;
		
		//Long idControl = null;
		Long idintegracion = null;
		Integer inicioPosicion = 1;
		
		/*if(control!=null) {
			controlRegistro = control;
			inicioPosicion = this.nwiCabControlService.getMaximaPosicion(idControl) +1;
		}*/
		//else {
			NwiCabControl controlNew = new NwiCabControl();
			controlNew.setIdintegracion(idintegracion);
			controlNew.setJsonBusqueda(jsonParams);
			controlNew = this.nwiCabControlService.registrar(controlNew);
			controlRegistro = controlNew;
		//}
		
		NwiCabIntegracionSap cab = new NwiCabIntegracionSap();
		NwiDetIntegracionSap det = new NwiDetIntegracionSap();
		
		cab.setUsuario_registra("encartonado");
		//cab.setJsontext(request.getJsonCabecera());
		cab.setEstado(1);
		cab.setUsuariomodifica("encartonado");
		det.setEstadoenviosap(1);
		det.setFecharegistro(new Date());
		det = this.detService.guardar(det);
		cab.setNwiDetalle(det);
		
		cab = nwiCabService.guardar(cab);
		
		idintegracion = cab.getIdcabintegracionsap();
		
		// registro de posiciones
		for(Map<String,Object> detalle:detalles) {
			
			NwiPosicionDetalle pd = new NwiPosicionDetalle();
			NwiPosicionDetallePK pdPK = new NwiPosicionDetallePK();
			
			Map<String,Object> detalleFinal = new HashMap<>();
			
			//detalleFinal.put("id_posicion", inicioPosicion);
			
			Map<String,Object> keysJson = null;
			
			try {
				//keysJson = (Map<String, Object>) detalle.get("JSON");
				Set<String> keysValoresJson = detalle.keySet();
				for ( String key : keysValoresJson ) {
					Object value = detalle.get(key);
					detalleFinal.put(key, value);	
		        }
				
			}
			catch(Exception ex) {
				keysJson = new HashMap<>();
				keysJson.put("valores", "nulos");
			}
			pdPK.setIdposicion(inicioPosicion);
			pdPK.setNwicabcontrol(controlRegistro);
			pdPK.setNwicabintegracionsap(cab);
			pd.setNwiLineaPk(pdPK);
			pd.setEstadoenviosap(1);
			pd.setFecharenvio(new Date());
			pd.setJsonEnvioSap(keysJson);
			pd = this.nwiCabControlService.guardarPosicion(pd);
			
			detalleSap.add(detalleFinal);
			//inicioPosicion++;
		}
		
		jsonGlobal.put("DETALLE", detalleSap);
		det.setJsonenviosap(jsonGlobal);
		this.detService.actualizar(det, det.getIddetintegracionsap());
	
		//cab.setNwiDetalle(det);
		
		//cab = this.nwiCabService.guardar(cab);
		
		response.put("id_integracion", idintegracion);
		response.put("detalles", detalleSap);
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> enviarEmpacadora(Map<String, Object> envio, String tipo_envio) {
		
		Map<String,Object> respSap = new HashMap<>();
		
		String url = "/".concat(tipo_envio);
		String endpoint = ValoresConstantes.urlMiddleware.concat("/enviar_empacadora").concat(url);
		
		respSap = conexionEnlace.postForObject(endpoint, envio, Map.class);

		return respSap;
	}

	

}
