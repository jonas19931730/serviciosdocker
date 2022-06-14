package com.nirsa.nw.web.app.servicioatunera.calidad.model.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nirsa.nw.web.app.servicioatunera.calidad.model.dao.ICalidadCatalogoEsterilizadoNovedadDao;
import com.nirsa.nw.web.app.servicioatunera.calidad.model.entity.CalidadCatalogoEsterilizadoNovedad;
import com.nirsa.nw.web.app.servicioatunera.calidad.model.services.ICalidadCatalogoEsterilizadoNovedadService;
import com.nirsa.nw.web.app.servicioatunera.model.entity.RequestSap;
import com.nirsa.nw.web.app.servicioatunera.model.entity.ResponseSap;
import com.nirsa.nw.web.app.servicioatunera.model.services.IEnlaceMiddlewareSap;

@Service
public class CalidadCatalogoEsterelizadoNovedadServiceImpl implements ICalidadCatalogoEsterilizadoNovedadService {

	@Autowired
	ICalidadCatalogoEsterilizadoNovedadDao catEstDao;

	@Autowired
	IEnlaceMiddlewareSap enlaceSap;

	@Override
	@Transactional(readOnly = true)
	public List<CalidadCatalogoEsterilizadoNovedad> listar() {
		return (List<CalidadCatalogoEsterilizadoNovedad>) catEstDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public CalidadCatalogoEsterilizadoNovedad findById(Integer id) {
		return catEstDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public CalidadCatalogoEsterilizadoNovedad guardar(CalidadCatalogoEsterilizadoNovedad payload) {
		return catEstDao.save(payload);
	}

	@Transactional
	@Override
	public CalidadCatalogoEsterilizadoNovedad actualizar(Integer id, CalidadCatalogoEsterilizadoNovedad payload) {
		CalidadCatalogoEsterilizadoNovedad old = catEstDao.findById(id).orElse(null);
		CalidadCatalogoEsterilizadoNovedad newPayload = null;
		if (old != null) {
			newPayload = catEstDao.save(payload);
		}
		return newPayload;
	}

	@Transactional
	@Override
	public void eliminar(Integer id) {
		try {
			catEstDao.deleteById(id);
		} catch (DataAccessException ex) {

		}
	}

	@Override
	@Transactional
	public ResponseSap enviarSap(CalidadCatalogoEsterilizadoNovedad payload, String idusuario) {
		RequestSap request = new RequestSap();
		request.setData(payload);
		request.setNombreServicio("calidad-esterilizado");
		request.setProceso("esterilizar");
		
		ResponseSap response = this.enlaceSap.enviarProceso(request);

		return response;
	}

}
