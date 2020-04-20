package com.cs.online_bank.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cs.online_bank.admin.http.HttpResult;
import com.cs.online_bank.admin.model.Communicate;
import com.cs.online_bank.admin.model.CommunicateUser;
import com.cs.online_bank.admin.service.CommunicateService;
@RestController("/communicate")
public class CommunicationController {
	@Autowired
	private CommunicateService communicateService;
	@GetMapping("/findCommunicate")
	public HttpResult findCommunicate() {
		List<Communicate> findCommunicate = communicateService.findCommunicate();
		if (findCommunicate==null) {
			return HttpResult.ok("抱歉，专家还没有发表评论");
		}
		System.out.println(findCommunicate.get(0).getName());
		System.out.println(findCommunicate.get(0).getImageUrl());
		return HttpResult.ok(findCommunicate);
	}
	
	@PostMapping("saveCommunicate")
	public HttpResult saveCommunicate(@RequestBody CommunicateUser communicateUser) {
		System.out.println(communicateUser);
		communicateService.saveCommunicate(communicateUser);
		return HttpResult.ok("发表成功");
	}
	@PutMapping("updateCommunicate")
	public HttpResult updateCommunicate(@RequestBody CommunicateUser communicateUser) {
		System.out.println("更新接口");
		communicateService.updateCommunicate(communicateUser);
		return HttpResult.ok("更新成功");
	}
	
}
