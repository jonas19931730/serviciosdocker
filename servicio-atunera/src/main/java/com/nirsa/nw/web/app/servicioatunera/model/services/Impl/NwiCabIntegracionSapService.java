package com.nirsa.nw.web.app.servicioatunera.model.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirsa.nw.web.app.servicioatunera.model.dao.INwiCabIntegracionSapDao;
import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiCabIntegracionSap;
import com.nirsa.nw.web.app.servicioatunera.model.services.INwiCabIntegracionSapService;

@Service
public class NwiCabIntegracionSapService implements INwiCabIntegracionSapService {

	@Autowired
	INwiCabIntegracionSapDao nwiCabDao;

	@Override
	public NwiCabIntegracionSap findById(Long id) {
		return nwiCabDao.findById(id).orElse(null);
	}

	@Override
	public List<NwiCabIntegracionSap> listar() {
		// TODO Auto-generated method stub
		return (List<NwiCabIntegracionSap>) nwiCabDao.findAll();
	}

	@Override
	public NwiCabIntegracionSap guardar(NwiCabIntegracionSap payload) {
		return nwiCabDao.save(payload);
	}

	@Override
	public NwiCabIntegracionSap actualizar(NwiCabIntegracionSap payload, Long id) {
		NwiCabIntegracionSap cabOld = this.findById(id);
		NwiCabIntegracionSap cabNew = null; 
		if(cabOld!=null) {
			cabNew = this.guardar(cabOld);
		}
		return cabNew;
	}

	

}
