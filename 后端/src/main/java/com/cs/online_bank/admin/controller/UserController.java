package com.cs.online_bank.admin.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cs.online_bank.admin.http.HttpResult;
import com.cs.online_bank.admin.model.User;
import com.cs.online_bank.admin.service.UserService;
@RestController("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/findOne")
	public HttpResult findOne(String userName) {
		System.out.println("进来了");
		return HttpResult.ok(userService.findByName(userName));
	}
	@PutMapping(value="/updateUser")
	public HttpResult updateUser(@RequestBody User user) {
		
		if (userService.findByName(user.getUserName())==null) {
			return HttpResult.error(201,"用户名错误");
		}
		userService.updateUser(user);
		return HttpResult.ok("修改成功");
	}
	
	

}
