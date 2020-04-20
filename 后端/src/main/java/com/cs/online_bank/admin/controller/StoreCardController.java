package com.cs.online_bank.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cs.online_bank.admin.http.HttpResult;
import com.cs.online_bank.admin.model.Report;
import com.cs.online_bank.admin.model.StoreCard;
import com.cs.online_bank.admin.model.Transfer;
import com.cs.online_bank.admin.service.StoreService;

@RestController(value="/store")
public class StoreCardController {
	@Autowired
	private StoreService storeService;
	
	//查找用户的储蓄卡信息
	@GetMapping(value="/findByName")
	public HttpResult findByName(@RequestParam String userName) {
		if(userName==null) {
			return HttpResult.error(201,"用户不存在");
		}
		List<StoreCard> storeCard=storeService.findByName(userName);
		if(storeCard==null) {
			return HttpResult.ok("该用户还没有储蓄卡");
		}
		return HttpResult.ok(storeCard);
	}
	
	//储蓄卡转账
	@PutMapping(value="/transfer")
	public HttpResult transfer(@RequestBody Transfer transfer) {
		String cardNumber1 = transfer.getCardNumber1();
		String cardNumber2 = transfer.getCardNumber2();
		//根据转账卡号获取卡号信息，以便判断输入信息正误
		Map<String, Object> findMessage1 = storeService.findMessage(cardNumber1);
		//判断卡号是否正确
		if (findMessage1==null) {
			return HttpResult.error(201,"转账卡号有误");
		}
		//判断该卡是否正常使用
		if (!findMessage1.get("status").toString().equals("0")) {
			return HttpResult.error(201,"抱歉，您的卡目前不能使用，请前往柜台办理相关手续");
		}
		//判断密码是否正确
		if(!findMessage1.get("password").equals(transfer.getPassword())) {
			return HttpResult.error(201,"密码不正确");
		}
		//判断转账卡余额是否充足
		String money1 = findMessage1.get("monye").toString();
		if(Double.parseDouble(findMessage1.get("money").toString())<Double.parseDouble(transfer.getMoney())) {
			return HttpResult.error(201,"抱歉，您的余额不足");
		}
		//根据被转账卡号获取相关信息，以便验证信息
		Map<String, Object> findMessage2 = storeService.findMessage(cardNumber2);
		//判断卡号是否正确
		if(findMessage2==null) {
			return HttpResult.error(201,"被转账卡号错误");
		}
		//判断被转账人姓名是否正确，避免转错
		if(!findMessage2.get("name").equals(transfer.getName())) {
			return HttpResult.error(201,"被转账人姓名错误");
		}
		String money2 = findMessage2.get("money").toString();
		//分别用相应的对象来装去新的信息，以便达到转账的目的
		StoreCard storeCard1=new StoreCard();
		storeCard1.setCardNumber(cardNumber1);
		storeCard1.setMoney(money1);
		StoreCard storeCard2=new StoreCard();
		storeCard2.setCardNumber(cardNumber2);
		storeCard2.setMoney(money2);
		storeService.transfer(storeCard1,storeCard2,transfer.getMoney());
		return HttpResult.ok("转账成功");
	}
	
	//储蓄卡挂失
	@PutMapping(value="/report")
	public HttpResult report(@RequestBody Report report) {
		String cardNumber = report.getCardNumber();
		//根据卡号获取相关信息，以便验证输入的信息是否正确
		Map<String, Object> map=storeService.findMessage(cardNumber);
		//判断姓名是否正确
		if(!map.get("realName").equals(report.getName())) {
			return HttpResult.error(201,"姓名错误");
		}
		//判断身份证号码是否正确
		if(!map.get("idNumber").equals(report.getIdNumber())) {
			return HttpResult.error(201,"身份证号码错误");
		}
		//判断密码是否正确
		if(!map.get("password").equals(report.getPassword())) {
			return HttpResult.error(201,"密码错误");
		}
		//用新的对象来装新的信息，更新挂失的信息
		StoreCard storeCard=new StoreCard();
		storeCard.setCardNumber(cardNumber);
		storeCard.setStatus(1);
		storeService.update(storeCard);
		return HttpResult.error("挂失成功");
	}
}
