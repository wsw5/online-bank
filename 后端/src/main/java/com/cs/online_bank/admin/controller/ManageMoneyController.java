package com.cs.online_bank.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.online_bank.admin.http.HttpResult;
import com.cs.online_bank.admin.model.ManageMoneyDeal;
import com.cs.online_bank.admin.model.ManageMoneyProduct;
import com.cs.online_bank.admin.model.ManageMoneyRegister;
import com.cs.online_bank.admin.model.StoreCard;
import com.cs.online_bank.admin.model.User;
import com.cs.online_bank.admin.service.ManageMoneyService;
import com.cs.online_bank.admin.service.StoreService;
import com.cs.online_bank.admin.service.UserService;

@RestController("/manageMoney")
public class ManageMoneyController {
	@Autowired
	private ManageMoneyService manageMoneyService;
	@Autowired
	private UserService userService;
	@Autowired
	private StoreService storeService;
	
	@GetMapping("/findManageMoneyProduct")
	public HttpResult findAll() {
		List<ManageMoneyProduct> list = manageMoneyService.findAll();
		if (list==null) {
			return HttpResult.ok("目前还没有理财产品");
		}
		return HttpResult.ok(list);
	}
	
	@PostMapping("/buyManage")
	public HttpResult buyManage(@RequestBody ManageMoneyRegister manageMoneyRegister) {
		String cardNumber = manageMoneyRegister.getCardNumber();
		String money = manageMoneyRegister.getMoney();
		User user = userService.findByName(manageMoneyRegister.getUserName());
		if (user==null) {
			return HttpResult.error("对不起，用户不存在");
		}
		if (!(user.getRealName().equals(manageMoneyRegister.getRealName()))) {
			return HttpResult.error("您的姓名有误");
		}
		if (!(user.getIdNumber().equals(manageMoneyRegister.getIdNumber()))) {
			return HttpResult.error("您的身份证有误");
		}
		Map<String, Object> findMessage = storeService.findMessage(cardNumber);
		
		if (findMessage==null) {
			return HttpResult.error("您的卡号有误");
		}
		String money2 = findMessage.get("money").toString();
		if (!findMessage.get("status").toString().equals("0")) {
			return HttpResult.error("您的卡号不能使用");
		}
		if (!(findMessage.get("password").equals(manageMoneyRegister.getPassword()))) {
			return HttpResult.error("您的密码输入有误");
		}
		if (Double.parseDouble(money2)<Double.parseDouble(money)) {
			return HttpResult.error("您的余额不足");
		}
		ManageMoneyDeal manageMoneyDeal=new ManageMoneyDeal();
		manageMoneyDeal.setmId(manageMoneyRegister.getMid());
		manageMoneyDeal.setStatus(0);
		manageMoneyDeal.setuId(user.getuId());
		manageMoneyDeal.setMoney(money);
		manageMoneyDeal.setCardNumber(cardNumber);
		StoreCard storeCard=new StoreCard();
		storeCard.setCardNumber(cardNumber);
		storeCard.setMoney(money2);
		manageMoneyService.save(manageMoneyDeal,storeCard,money);
		return HttpResult.ok("购买成功");
	}
	
	@GetMapping("findManageDeal")
	public HttpResult findManageDeal(Integer id) {
		List<ManageMoneyDeal> findDeal = manageMoneyService.findDeal(id);
		return HttpResult.ok(findDeal);
	}
	
}
