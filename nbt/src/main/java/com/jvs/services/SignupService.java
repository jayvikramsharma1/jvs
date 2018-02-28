package com.jvs.services;

import com.jvs.models.SignupPOJO;

public interface SignupService {
	public boolean isFirstMember();
	public String doSignUp(SignupPOJO signupPojo);
	public String validateUser(String username);
}
