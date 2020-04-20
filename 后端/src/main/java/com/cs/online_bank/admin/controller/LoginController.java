package com.cs.online_bank.admin.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cs.online_bank.admin.http.HttpResult;
import com.cs.online_bank.admin.model.LoginUser;
import com.cs.online_bank.admin.model.User;
import com.cs.online_bank.admin.security.JwtAuthenticatioToken;
import com.cs.online_bank.admin.service.UserService;
import com.cs.online_bank.admin.util.PasswordUtils;
import com.cs.online_bank.admin.util.SecurityUtils;
@RestController
public class LoginController {
	@Autowired
	private UserService userServiece;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	//登录账户
	@PostMapping(value = "/login")
	public HttpResult login(@RequestBody LoginUser loginUser, HttpServletRequest request) throws IOException {
		String userName = loginUser.getUserName();
		String password = loginUser.getPassword();
		// 用户信息
		User user =userServiece.findByName(userName);
		// 账号不存在、密码错误
		if (user == null) {
			return HttpResult.error(201,"账号不存在");
		}
		if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
			return HttpResult.error(201,"密码不正确");
		}
		// 账号锁定
		if (!(user.getStatus()== 0)) {
			return HttpResult.error(201,"账号已被锁定,请联系管理员或等待一个小时");
		}
		System.out.println(111);
		// 系统登录认证
		JwtAuthenticatioToken token = SecurityUtils.login(request, userName, password, authenticationManager);
		return HttpResult.ok(token);
	}

}
