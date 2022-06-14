package com.nirsa.nw.web.app.servicioatunera.calidad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nirsa.nw.web.app.servicioatunera.calidad.model.entity.CalidadCatalogoEsterilizadoNovedad;
import com.nirsa.nw.web.app.servicioatunera.calidad.model.services.ICalidadCatalogoEsterilizadoNovedadService;
import com.nirsa.nw.web.app.servicioatunera.model.entity.ResponseSap;
import com.nirsa.nw.web.app.servicioatunera.model.services.ILogTransaccionSapService;

@RequestMapping("/calidad")
@RestController
public class CalidadCatalogoEsterilizadoNovedadController {
	
	@Autowired
	private ICalidadCatalogoEsterilizadoNovedadService calCatService;
	
	@Autowired
	private ILogTransaccionSapService transService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> prueba(){
		return new ResponseEntity<List<CalidadCatalogoEsterilizadoNovedad>>(calCatService.listar(),HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@RequestBody CalidadCatalogoEsterilizadoNovedad payload ){
		
		try {
			CalidadCatalogoEsterilizadoNovedad response = this.calCatService.guardar(payload);
			
			return new ResponseEntity<CalidadCatalogoEsterilizadoNovedad>(response,HttpStatus.OK);
		}
		catch(DataAccessException ex) {
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@PostMapping("/enviarSap/{idusuario}")
	public ResponseEntity<?> enviarSap(@RequestBody CalidadCatalogoEsterilizadoNovedad payload,@PathVariable String idusuario ){
		ResponseSap response = null;
		try {
			response = this.calCatService.enviarSap(payload,idusuario);	
			
		}
		catch(DataAccessException ex) {
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.transService.registrarEnvioTransaccion(idusuario);
		return new ResponseEntity<ResponseSap>(response,HttpStatus.OK);
	}

	
}
