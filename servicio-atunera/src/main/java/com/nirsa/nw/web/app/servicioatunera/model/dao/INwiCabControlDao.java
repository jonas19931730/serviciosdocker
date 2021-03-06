package com.nirsa.nw.web.app.servicioatunera.model.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nirsa.nw.web.app.servicioatunera.model.entity.NwiCabControl;

public interface INwiCabControlDao extends CrudRepository<NwiCabControl,Long> {
	
	@Query("select cab from NwiCabControl cab where cab.jsonBusqueda = ?1 ")
	public List<NwiCabControl> buscarPorJsonBusqueda(Map<String,Object> busqueda);
	
	
}
