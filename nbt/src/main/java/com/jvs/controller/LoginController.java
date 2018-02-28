package com.jvs.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jvs.enums.ViewsMeta;
import com.jvs.models.UserLoginPOJO;
import com.jvs.models.UserPOJO;
import com.jvs.services.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public String showLoginPage() {
		return ViewsMeta.LOGIN.toString();
	}
	
	@PostMapping("/login")
	public String loginAction(@ModelAttribute @Valid UserLoginPOJO userLogin, BindingResult result, ModelMap modelmap, HttpSession session, HttpServletRequest request) {
		System.out.println("Login Credentials -------- " + userLogin);
		UserPOJO sessionUser = checkUserInSession(session, userLogin);
		System.out.println("Session User ------- " + sessionUser);
		if(sessionUser != null)
			return ViewsMeta.HOME.toString(); 
		UserPOJO user = loginService.getUserByUserNameAndPassword(userLogin);
		if(user == null || user.getUsername() == null || user.getUsername().equals("")) {
			createSession(session, user);
			return ViewsMeta.SIGNUP.toString();
		}
		else
			return ViewsMeta.HOME.toString();
	}
	
	public UserLoginPOJO checkUserCookies(HttpServletRequest request) {
		UserLoginPOJO userLogin = null;
		Cookie[] cookies = request.getCookies();
		String username = "";
		String password = "";
		String roles = "";
		for(Cookie ck : cookies) {
			if(ck.getName().equalsIgnoreCase("username"))
				username = ck.getValue();
			if(ck.getName().equalsIgnoreCase("password"))
				password = ck.getValue();
			if(ck.getName().equalsIgnoreCase("roles"))
				roles = ck.getValue();
		}
		if(!username.isEmpty() && !password.isEmpty() && !roles.isEmpty()) {
			userLogin = new UserLoginPOJO();
			userLogin.setUsername(username);
			userLogin.setPassword(password);
			userLogin.setRole(roles);
		}
		return userLogin;
	}
	
	public UserPOJO checkUserInSession(HttpSession session, UserLoginPOJO userLogin) {
		UserPOJO user = null;
		if(session.getAttribute("username").toString().equalsIgnoreCase(userLogin.getUsername()) &&
				session.getAttribute("password").toString().equalsIgnoreCase(passwordEncoder.encode(userLogin.getPassword()))) {
			user = new UserPOJO();
			user.setFullname(session.getAttribute("username").toString());
			user.setUsername(session.getAttribute("username").toString());
			user.setRoles(session.getAttribute("roles").toString());
		}
		return  user;
	}
	
	public void clearSession(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("password");
		session.removeAttribute("roles");
	}
	
	public void createSession(HttpSession session, UserPOJO user) {
		session.setAttribute("username", user.getFullname());
		session.setAttribute("fullname", user.getFullname());
		session.setAttribute("roles", user.getRoles());
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		clearSession(session);
		return ViewsMeta.LOGOUT.toString();
	}
}
