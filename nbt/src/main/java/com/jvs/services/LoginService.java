package com.jvs.services;

import com.jvs.models.UserLoginPOJO;
import com.jvs.models.UserPOJO;

public interface LoginService {
	public UserPOJO getUserByUserNameAndPassword(UserLoginPOJO loginPojo);
}
