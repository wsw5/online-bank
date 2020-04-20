package com.cs.online_bank.admin.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cs.online_bank.admin.http.HttpResult;
import com.cs.online_bank.admin.model.CreditUser;
import com.cs.online_bank.admin.model.Pay;
import com.cs.online_bank.admin.model.PayBill;
import com.cs.online_bank.admin.model.Report;
import com.cs.online_bank.admin.model.StoreCard;
import com.cs.online_bank.admin.service.CreditService;
import com.cs.online_bank.admin.service.StoreService;
@RestController("/credit")
public class CreditController {
	@Autowired
	private CreditService creditService;
	@Autowired
	private StoreService storeService;
	
	//查询用户的信用卡
	@GetMapping(value="/findCredit")
	public HttpResult findByName(@RequestParam String userName) {
		if(userName==null) {
			return HttpResult.error(201,"该用户不存在");
		}
		List<CreditUser> creditUser = creditService.findByName(userName);
		//判断是否为空
		if(creditUser==null) {
			return HttpResult.error(201,"该用户还没有办理信用卡，请到柜台办理");
		}
		return HttpResult.ok(creditUser);
	}
	
	//信用卡挂失
	@PutMapping(value="Report")
	public HttpResult creditReport(@RequestBody Report report) {
		String cardNumber = report.getCardNumber();
		//查询信用卡相关信息，以便判断输入信息是否正确
		Map<String, Object> map=creditService.findMessage(cardNumber);
		//判断卡号是否正确
		if(map==null) {
			return HttpResult.error(201,"卡号输入有误");
		}
		//判断身份证号
		if (!report.getIdNumber().equals(map.get("idNumber"))) {
			return HttpResult.error(201,"身份证输入有误");
		}
		//判断姓名输入是否正确
		if (!report.getName().equals(map.get("realName"))) {
			return HttpResult.error(201,"输入姓名有误");
		}
		//判断密码输入是否正确
		if (!report.getPassword().equals(map.get("password"))) {
			return HttpResult.error(201,"输入密码有误");
		}
		//用新的信用卡对象装新的信息并挂失
		CreditUser creditUser=new CreditUser();
		creditUser.setCardNumber(cardNumber);
		creditUser.setStatus(1);
		creditService.creditReport(creditUser);
		return HttpResult.ok("挂失成功");
	}
	
	//信用卡还款
	@PutMapping(value="pay")
	public HttpResult pay(@RequestBody PayBill payBill) {
		String cardNumber1 = payBill.getCardNumber1();
		String cardNumber2 = payBill.getCardNumber2();
		String money = payBill.getMoney();
		//根据卡号获取信用卡相关信息，以便判断输入信息正误
		Map<String, Object> findMessage = creditService.findMessage(cardNumber1);
		//判断卡号是否正确
		if (findMessage==null) {
			return HttpResult.error(201,"输入卡号有误");
		}
		//根据卡号获取还款卡号的相关信息，以便判断输入信息正误
		Map<String, Object> findMessage2 = storeService.findMessage(cardNumber2);
		//判断卡号是否正确
		if (findMessage2==null) {
			return HttpResult.error(201,"输入还款卡号有误");
		}
		//判断该卡是否能正常使用
		if (!findMessage2.get("status").toString().equals("0")) {
			return HttpResult.error(201,"抱歉，该卡暂时不能使用，请到柜台办理相关手续");
		}
		//判断密码是否正确
		if (!findMessage2.get("password").equals(payBill.getPassword())) {
			return HttpResult.error(201,"输入还款密码有误");
		}
		//判断还款金额是否足够
		String money2 = findMessage2.get("money").toString();
		if (money2==null||Double.parseDouble(money2)<Double.parseDouble(money)) {
			return HttpResult.error(201,"还款账户余额不足");
		}
		//分别用新的对象来装需要修改的信息，以便达到还款
		Pay pay=new Pay();
		pay.setId(payBill.getId());
		pay.setPaytotal(payBill.getMoney());
		StoreCard storeCard=new StoreCard();
		storeCard.setCardNumber(cardNumber2);
		storeCard.setMoney(money2);
		creditService.payBill(pay,storeCard);
		return HttpResult.ok("还款成功");
	}
}
