package com.nirsa.nw.web.app.servicioatunera.model.services.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nirsa.nw.web.app.servicioatunera.model.dao.ILogTransaccionSapDao;
import com.nirsa.nw.web.app.servicioatunera.model.entity.LogTransaccionSap;
import com.nirsa.nw.web.app.servicioatunera.model.services.ILogTransaccionSapService;

@Service
public class LogTransaccionSapServiceImpl implements ILogTransaccionSapService{
	
	
	@Autowired
	private ILogTransaccionSapDao logDao;

	@Transactional(readOnly = true)
	@Override
	public List<LogTransaccionSap> listar() {
		return (List<LogTransaccionSap>) logDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<LogTransaccionSap> listarEnviadas() {
		return logDao.listarEnviadas();
	}

	@Transactional(readOnly = true)
	@Override
	public List<LogTransaccionSap> listarFinalizadas() {
		return logDao.listarRecibidas();
	}

	@Transactional
	@Override
	public void registrarEnvioTransaccion(String idUsuario) {
		LogTransaccionSap payload = new LogTransaccionSap();
		payload.setFechaEnviado(new Date());
		payload.setIdUsuario(idUsuario);
		logDao.save(payload);
		
		
	}
	@Transactional
	@Override
	public void registrarTransaccionFinalizada(Long id) {
		
		LogTransaccionSap transaccion = logDao.findById(id).orElse(null);
		
		if(transaccion!=null){
			transaccion.setFechaRecibido(new Date());
			transaccion.setIdSap("ID_SAP");
			logDao.save(transaccion);
		}
		
	}
	
}
