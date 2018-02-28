package com.jvs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jvs.dao.UserDao;
import com.jvs.entity.User;
import com.jvs.models.UserLoginPOJO;
import com.jvs.models.UserPOJO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserPOJO getUserByUserNameAndPassword(UserLoginPOJO loginPojo) {
		UserPOJO userPojo = new UserPOJO();
		
		User userEntity = userDao.getUserByUserNameAndPassword(loginPojo.getUsername(), bCryptPasswordEncoder.encode(loginPojo.getPassword()), loginPojo.getRole());
		//User userEntity = loginDao.findAll().get(0);
		if(userEntity != null) {
			userPojo.setFullname(userEntity.getFullname());
			userPojo.setUsername(userEntity.getUsername());
			userPojo.setRoles(userEntity.getRoles());
		}
		return userPojo;
	}

}
