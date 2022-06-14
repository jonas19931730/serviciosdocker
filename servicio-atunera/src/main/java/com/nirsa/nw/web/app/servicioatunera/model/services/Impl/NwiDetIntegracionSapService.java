package com.nirsa.nw.web.app.servicioatunera.model.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nirsa.nw.web.app.servicioatunera.model.dao.INwiDetIntegracionSapDao;
import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiCabIntegracionSap;
import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiDetIntegracionSap;
import com.nirsa.nw.web.app.servicioatunera.model.services.INwiDetIntegracionSapService;

@Service
public class NwiDetIntegracionSapService implements INwiDetIntegracionSapService {

	@Autowired
	INwiDetIntegracionSapDao nwiDetDao;

	@Override
	@Transactional(readOnly = true)
	public NwiDetIntegracionSap findById(Long id) {
		return nwiDetDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<NwiDetIntegracionSap> listar() {
		return (List<NwiDetIntegracionSap>) nwiDetDao.findAll();
	}

	@Override
	@Transactional
	public NwiDetIntegracionSap guardar(NwiDetIntegracionSap payload) {
		return nwiDetDao.save(payload);
	}

	@Override
	@Transactional
	public void actualizarOrdenesFinalizadas(List<NwiDetIntegracionSap> payload) {
		
	}

	@Override
	@Transactional(readOnly = true)
	public NwiDetIntegracionSap findByDetalleyCabecera(Long iddetalle, Long idcabecera) {
		return this.nwiDetDao.findByDetalleyCabecera(iddetalle, idcabecera);
	}

	@Override
	@Transactional
	public NwiDetIntegracionSap actualizar(NwiDetIntegracionSap payload, Long id) {
		NwiDetIntegracionSap detOld = this.findById(id);
		NwiDetIntegracionSap detNew = null; 
		if(detOld!=null) {
			detNew = this.guardar(detOld);
		}
		
		return detNew;
	}

}
