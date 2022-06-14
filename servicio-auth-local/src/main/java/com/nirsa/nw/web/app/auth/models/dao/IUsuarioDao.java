package com.nirsa.nw.web.app.auth.models.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nirsa.nw.web.app.auth.models.entity.User;

public interface IUsuarioDao extends CrudRepository<User,String> {

	@Query("select u from User u where u.idusuario=?1 ")
	public Optional<User> findByUserName(String idusuario);
	
	@Query("select u from User u where u.idusuario=?1 ")
	public User buscarUsuario(String idusuario);
}
