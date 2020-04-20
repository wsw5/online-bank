package com.cs.online_bank.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cs.online_bank.admin.http.HttpResult;
import com.cs.online_bank.admin.model.User;
import com.cs.online_bank.admin.service.UserService;
import com.cs.online_bank.admin.util.PasswordUtils;

@RestController
public class RegisterController {
	@Autowired
	private UserService userServiece;

	//注册用户
	@PostMapping(value="/register")
	public HttpResult register(@RequestBody User user) {
		//查账所有用户
		List<User> list = userServiece.findAll();
		//判断用户名是否存在
		if(!(list==null)) {
			for (User user2 : list) {
				if (user2.getUserName()==user.getUserName()||user2.getUserName().equals(user)) {
					return HttpResult.error(201,"用户名已存在");
				}
			}
		}
		//生成salt
		String salt = PasswordUtils.getSalt();
		//加密
		String password = PasswordUtils.encode(user.getPassword(), salt);
		user.setPassword(password);
		user.setSalt(salt);
		user.setStatus(1);
		userServiece.save(user);
		return HttpResult.ok("申请成功，请待24个小时后工作人员验证方可进入系统");

	}
	//获取手机验证码
	@GetMapping(value="/sendCode")
	public HttpResult sendCode(@RequestParam String phone) {
		
		Map<String, Object> map=new HashMap<>();
		//生成四位数验证码
		String verificationCode = String.valueOf((int)((Math.random()*9+1)*1000));
		
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FcPdaSUtYH3SuqpvoqJ", "nN3rKvnJ2g38m2u6dHnonpwws6CHdj");
		IAcsClient client = new DefaultAcsClient(profile);
		CommonRequest request = new CommonRequest();
		//发送方式
		request.setMethod(MethodType.POST);
		request.setDomain("dysmsapi.aliyuncs.com");
		request.setVersion("2017-05-25");
		request.setAction("SendSms");
		
		request.putQueryParameter("RegionId", "cn-hangzhou");
		//手机号码
		request.putQueryParameter("PhoneNumbers", phone);

		//短信模板
		request.putQueryParameter("TemplateCode", "SMS_184115579");
		request.putQueryParameter("TemplateParam", "{\"code\":\""+verificationCode+"\"}");
		
		try {
			CommonResponse response = client.getCommonResponse(request);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return HttpResult.ok("发送成功");

	}
}
