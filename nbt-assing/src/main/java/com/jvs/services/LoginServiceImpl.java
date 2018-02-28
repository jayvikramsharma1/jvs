package com.jvs.services;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public boolean validateUser(String username, String password) {
		if(username.equals(password))
			return true;
		else
			return false;
	}

}
