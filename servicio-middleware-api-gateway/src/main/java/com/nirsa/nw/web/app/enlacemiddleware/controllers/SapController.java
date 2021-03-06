package com.nirsa.nw.web.app.enlacemiddleware.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nirsa.nw.web.app.enlacemiddleware.services.ISapService;
@CrossOrigin(origins = "*")
@RestController
public class SapController {

	@Autowired
	ISapService sapService;

	@PostMapping("/enviarOrden")
	public Map<String,Object> enviarOrden(@RequestBody Map<String,Object> request){
		Map<String,Object> response = new HashMap<String,Object>();
		try {
			response = sapService.enviarCreacionOrden(request);		
		}
		catch(Exception ex) {
			response.put("mensaje", ex.getMessage());
		}
		return response;
		
	}
	
	@PostMapping("/enviarNotificacion")
	public Map<String,Object> enviarNotificacion(@RequestBody Map<String,Object> request){
		Map<String,Object> response = new HashMap<String,Object>();
		try {
			response = sapService.enviarNotificacion(request);		
		}
		catch(Exception ex) {
			response.put("mensaje", ex.getMessage());
		}
		return response;
		
	}

	@PostMapping("/recibir")
	public ResponseEntity<Map<String, Object>> recibir(@RequestBody List<Map<String,Object>> responseSap) {
		Map<String, Object> response = new HashMap<>();
		try {
			response = this.sapService.recibir(responseSap);
		} catch (Exception ex) {
			if (ex != null) {
				response.put("mensaje", ex.getMessage());
			}

			response.put("estado", "error");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/enviar_empacadora/{tipo_integracion}")
	public ResponseEntity<Map<String, Object>> enviarEmpacadora(@RequestBody Map<String,Object> envioSap,@PathVariable String tipo_integracion) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			response = this.sapService.enviarEmpacadora(envioSap,tipo_integracion );
		} 
		catch (Exception ex) {
			if (ex != null) {
				response.put("mensaje", ex.getMessage());
			}
			response.put("estado", "error");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	

}
