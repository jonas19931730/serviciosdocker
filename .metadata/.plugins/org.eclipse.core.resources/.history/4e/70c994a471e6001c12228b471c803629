package com.nirsa.nw.web.app.servicioatunera.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nirsa.nw.web.app.servicioatunera.model.entity.LogTransaccionSap;

public interface ILogTransaccionSapDao extends CrudRepository<LogTransaccionSap,Long> {
	
	@Query("select l from LogTransaccionSap l where l.fechaRecibido is null")
	public List<LogTransaccionSap> listarEnviadas();
	
	@Query("select l from LogTransaccionSap l where l.fechaRecibido is not null")
	public List<LogTransaccionSap> listarRecibidas();
}
