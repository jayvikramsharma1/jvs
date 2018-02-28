package com.jvs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jvs.dao.UserDao;
import com.jvs.entity.User;
import com.jvs.models.SignupPOJO;
import com.jvs.utils.RolesUtil;

@Service
public class SignupServiceImpl implements SignupService{
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	BCryptPasswordEncoder encryptPassword;
	
	@Override
	public boolean isFirstMember() {
		long userCount = userDao.getCountOfUsers();
		if(userCount > 0)
			return false;
		else
			return true;
	}

	@Override
	public String doSignUp(SignupPOJO signupPojo) {
		if(signupPojo !=null && signupPojo.getPassword().equals(signupPojo.getCnfpassword())) {
			String fname = validateUser(signupPojo.getUsername());
			if(fname == null || fname.equals("")) {
				User user = new User();
				user.setFullname(signupPojo.getFullname());
				user.setPassword(encryptPassword.encode(signupPojo.getPassword()));
				user.setUsername(signupPojo.getUsername());
				boolean isFirstMember = isFirstMember();
				if(isFirstMember == true) {
					user.setRoles(RolesUtil.getAdminRoles());
					System.out.println(user);
					userDao.save(user);
					
				} else {
					user.setRoles(RolesUtil.getRolesByName(signupPojo.getRoles()));
					System.out.println(user);
					userDao.save(user);
				}
				return user.getUsername();
			} else {
				return fname;
			}
			
		}
		return null;
	}

	@Override
	public String validateUser(String username) {
		User user = userDao.getUserByUserName(username);
		if(user != null && user.getId() != null && user.getUsername() !=null) {
			System.out.println("UserName already Found");
			return user.getFullname();
		}
		return null;
	}

}
