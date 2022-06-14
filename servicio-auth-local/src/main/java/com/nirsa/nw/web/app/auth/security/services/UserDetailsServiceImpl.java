package com.nirsa.nw.web.app.auth.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nirsa.nw.web.app.auth.models.dao.IUsuarioDao;
import com.nirsa.nw.web.app.auth.models.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUsuarioDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("Indetificación no encontrada; identificación: " + username));
		return UserDetailsImpl.build(user);	
	}

}
