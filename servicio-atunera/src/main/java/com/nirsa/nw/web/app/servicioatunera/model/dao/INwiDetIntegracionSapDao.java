package com.nirsa.nw.web.app.servicioatunera.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiDetIntegracionSap;

public interface INwiDetIntegracionSapDao extends CrudRepository<NwiDetIntegracionSap,Long> {
	
	@Query("select d from NwiDetIntegracionSap d where d.iddetintegracionsap = ?1 "
			+ "and d.nwicabintegracionsap.idcabintegracionsap= ?2")
	public NwiDetIntegracionSap findByDetalleyCabecera(Long iddetalle,Long idcabecera);
}
