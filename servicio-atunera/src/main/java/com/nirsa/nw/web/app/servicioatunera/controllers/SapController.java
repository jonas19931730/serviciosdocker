package com.nirsa.nw.web.app.servicioatunera.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nirsa.nw.web.app.servicioatunera.model.dto.RequestMonitor;
import com.nirsa.nw.web.app.servicioatunera.model.services.IEnlaceMiddlewareSap;
import com.nirsa.nw.web.app.servicioatunera.model.services.INwiDetIntegracionSapService;
import com.nirsa.nw.web.app.servicioatunera.model.services.ISapService;
import com.nirsa.nw.web.app.servicioatunera.utils.ValoresConstantes;


@RequestMapping("/sap")
@CrossOrigin(origins = "*")
@RestController
public class SapController {
	
	@Autowired
	IEnlaceMiddlewareSap enlace;
	
	@Autowired
	ISapService sapService;
	
	@Autowired
	INwiDetIntegracionSapService detService;
	
	@PostMapping("/enviar/{tipo_envio}")
	public ResponseEntity<?> enviar(@RequestBody RequestMonitor request, @PathVariable String tipo_envio) {
		Map<String,Object> response = new HashMap<>();
		Map<String,Object> data = null;
		
		try {
			 data = sapService.enviar(request,tipo_envio);
		}
		catch(DataAccessException ex) {
			response.put("mensaje", ex.getMostSpecificCause().getMessage());
			return new ResponseEntity<Object>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(data==null) {
			response.put("mensaje","No se encontraron datos");
			return new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
		}
		response.put("data", data);
		return new ResponseEntity<Object>(response,HttpStatus.OK);
		
	}
	
	@PostMapping("/recibir")
	public ResponseEntity<Map<String,Object>> recibir(@RequestBody List<Map<String,Object>> responseSap) {
			Map<String,Object> response = new HashMap<String,Object>();
			Map<String,Object> respuestaSap = new HashMap<String,Object>();
			try {
				respuestaSap = this.sapService.recibirSap(responseSap);
			}
			catch(DataAccessException ex) {
				response.put("estado", "error");
				response.put("mensaje", ex.getMostSpecificCause().getMessage());
				
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<Map<String,Object>>(respuestaSap,HttpStatus.OK);
	}
	
	@PostMapping("/enviar_empacadora/{tipo_envio}")
	public ResponseEntity<Map<String,Object>> enviarEmpacadora(@RequestBody Map<String,Object> responseSap,@PathVariable String tipo_envio) {
		Map<String,Object> response = new HashMap<String,Object>();
		
		try {
			response = this.sapService.enviarEmpacadora(response, tipo_envio);
		}
		catch(DataAccessException ex) {
			//response.put("error", ex.getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	

}
