package com.jvs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jvs.dao.UserDao;
import com.jvs.enums.ViewsMeta;
import com.jvs.models.SignupPOJO;
import com.jvs.models.UserPOJO;
import com.jvs.services.SignupService;

@Controller
public class SignupController {
	
	@Autowired
	SignupService signupService;
	@Autowired
	UserDao userDao;
	
	@GetMapping("/signup")
	public String getSignupPage() {
		return ViewsMeta.SIGNUP.toString();
	}
	
	@PostMapping("/signup")
	public String signupAction(@ModelAttribute @Valid SignupPOJO signup, BindingResult result) {
		String response = signupService.doSignUp(signup);
		System.out.println(userDao.findAll());
		if(response == null || response.equals(""))
			return ViewsMeta.SIGNUP.toString();
		else
			return ViewsMeta.LOGIN.toString();
	}
	
	

}
