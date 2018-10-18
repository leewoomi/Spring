package com.lee.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.mvc.dao.LoginDao;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;
	
	
	public String idcheck(String id) {
		return loginDao.idcheck(id);
	}
	
}
