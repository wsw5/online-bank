package com.cs.online_bank.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.online_bank.admin.http.HttpResult;
import com.cs.online_bank.admin.model.FundDeal;
import com.cs.online_bank.admin.model.FundProduct;
import com.cs.online_bank.admin.model.Redeem;
import com.cs.online_bank.admin.service.FundService;
import com.cs.online_bank.admin.service.StoreService;

@RestController("/fund")
public class FundController {
	@Autowired
	private FundService fundService;
	@Autowired
	private StoreService storeService;
	@GetMapping("findFund")
	public HttpResult findFund() {
		List<FundProduct> fund = fundService.findAll();
		if (fund==null) {
			return HttpResult.ok("抱歉，目前还没有基金产品");
		}
		return HttpResult.ok(fund);
	}
	@PostMapping("saveFund")
	public HttpResult saveFund(@RequestBody FundDeal fundDeal) {
		String cardNumber = fundDeal.getCardNumber();
		Map<String, Object> findMessage = storeService.findMessage(cardNumber);
		if (findMessage==null) {
			HttpResult.error(201,"卡号不正确");
		}
		if (fundDeal.getPassword()!=findMessage.get("password")) {
			HttpResult.error(201,"密码不正确");
		}
		if (Double.parseDouble(fundDeal.getAllMoney())>Double.parseDouble(findMessage.get("money").toString())) {
			HttpResult.error(201,"抱歉，余额不足");
		}
		fundService.saveFund(fundDeal);
		return HttpResult.ok("申购成功");
	}
	//赎回基金
	@PostMapping("saveRedeem")
	public HttpResult saveRedeem(@RequestBody Redeem redeem) {
		System.out.println(redeem);
		fundService.saveRedeem(redeem);
		return HttpResult.ok("赎回申请成功，服务器会根据申请在一到两个工作日返回金额");
	}
}
