package com.nirsa.nw.web.app.servicioatunera.model.services.Impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nirsa.nw.web.app.servicioatunera.model.dao.INwiCabControlDao;
import com.nirsa.nw.web.app.servicioatunera.model.dao.INwiPosicionDetalleDao;
import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiCabControl;
import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiPosicionDetalle;
import com.nirsa.nw.web.app.servicioatunera.model.services.ICabControlService;

@Service
public class CabControlService implements ICabControlService {
	
	@Autowired
	INwiCabControlDao controlDao;
	
	@Autowired
	INwiPosicionDetalleDao pdDao;
	
	@Transactional(readOnly = true)
	@Override
	public NwiCabControl buscarPorJson(Map<String, Object> params) {
		ObjectMapper mapper = new ObjectMapper();
		
		//boolean ok = assertEquals(mapper.readTree(s1), mapper.readTree(s2));
		//NwiCabControl result = controlDao.buscarPorJsonBusqueda(params).get(0);
		return null;
	}

	@Override
	@Transactional
	public NwiCabControl registrar(NwiCabControl control) {
		return controlDao.save(control);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer getMaximaPosicion(Long idcontrol) {
		return pdDao.getMaximaPosicionPorControl(idcontrol);
	}

	@Override
	@Transactional
	public NwiPosicionDetalle guardarPosicion(NwiPosicionDetalle pd) {
		return pdDao.save(pd);
	}

}
