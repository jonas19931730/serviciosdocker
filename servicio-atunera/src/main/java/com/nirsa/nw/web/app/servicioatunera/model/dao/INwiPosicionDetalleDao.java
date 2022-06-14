package com.nirsa.nw.web.app.servicioatunera.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiPosicionDetalle;
import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiPosicionDetallePK;

public interface INwiPosicionDetalleDao extends CrudRepository<NwiPosicionDetalle,NwiPosicionDetallePK> {
	
	@Query("select max(pd.nwiLineaPk.idposicion) from NwiPosicionDetalle pd where pd.nwiLineaPk.nwicabcontrol.idControl = ?1 ")
	public Integer getMaximaPosicionPorControl(Long idcontrol);
	
	
}
