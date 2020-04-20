package com.cs.online_bank.admin.job;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.transaction.annotation.Transactional;

import com.cs.online_bank.admin.model.Communicate;
import com.cs.online_bank.admin.model.CommunicateUser;
import com.cs.online_bank.admin.model.CreditUser;
import com.cs.online_bank.admin.model.ManageMoneyDeal;
import com.cs.online_bank.admin.model.ManageMoneyProduct;
import com.cs.online_bank.admin.model.Pay;
import com.cs.online_bank.admin.model.StoreCard;
import com.cs.online_bank.admin.service.CommunicateService;
import com.cs.online_bank.admin.service.CreditService;
import com.cs.online_bank.admin.service.ManageMoneyService;
import com.cs.online_bank.admin.service.StoreService;
@Transactional
public class MyJob extends QuartzJobBean{
	@Autowired
	private CreditService creditService;
	@Autowired 
	private ManageMoneyService manageMoneyService;
	@Autowired
	private CommunicateService communicateService;
	
	@Autowired
	private StoreService storeService;
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("开始执行");
		Date time=new Date();
		//任务一
		long nd = 1000 * 24 * 60 * 60;
		List<Pay> list = creditService.findAll();
		for (Pay pay : list) {
			Date payday = pay.getPayday();
			if(time.compareTo(payday)>0) {
				long differ=(time.getTime()-payday.getTime())/nd;
				String interset=String.format("%.2f", (Double.parseDouble(pay.getBill())-Double.parseDouble(pay.getPaied()))*0.0005*differ);
				pay.setInterest(interset);
				String paytotal=String.format("%.2f", Double.parseDouble(interset)+Double.parseDouble(pay.getBill())-Double.parseDouble(pay.getPaied()));
				pay.setPaytotal(paytotal);

			}
			creditService.update(pay);
		}

		//任务二
		List<ManageMoneyProduct> findDealAll = manageMoneyService.findDealAll();
		for (ManageMoneyProduct manageMoneyProduct : findDealAll) {
			Date endTime = manageMoneyProduct.getEndTime();
			List<ManageMoneyDeal> manageMoneyDeals = manageMoneyProduct.getManageMoneyDeals();
			if (endTime==time) {
				manageMoneyProduct.setStatus(1);
				manageMoneyService.updateProduct(manageMoneyProduct);
				
				for (ManageMoneyDeal manageMoneyDeal : manageMoneyDeals) {
					manageMoneyDeal.setStatus(1);
					manageMoneyService.updateDeal(manageMoneyDeal);
				}
			}
			if (time.compareTo(endTime)>0&&((time.getTime()-endTime.getTime())/nd>=368 )) {
				for (ManageMoneyDeal manageMoneyDeal : manageMoneyDeals) {
					Double money=Double.parseDouble(manageMoneyDeal.getMoney());
					Double countMoney=money*Double.parseDouble(manageMoneyProduct.getRate())+money;
					manageMoneyDeal.setCountMoney(String.valueOf(countMoney));
					manageMoneyDeal.setStatus(2);
					String cardNumber = manageMoneyDeal.getCardNumber();
					Map<String, Object> findMessage = storeService.findMessage(cardNumber);
					Double oldMoney = Double.parseDouble(findMessage.get("money").toString());
					Double newMoney=countMoney+oldMoney;
					StoreCard storeCard=new StoreCard();
					storeCard.setCardNumber(cardNumber);
					storeCard.setMoney(String.valueOf(newMoney));
					manageMoneyService.updateDeal(manageMoneyDeal);
					storeService.update(storeCard);
				}
			}

		}
		//任务三
		List<Communicate> communicate = communicateService.findCommunicate();
		for (Communicate communicateUser : communicate) {
			if (time.compareTo(communicateUser.getEndTime())>=0) {
				CommunicateUser communicateUser2=new CommunicateUser();
				communicateUser2.setId(communicateUser.getId());
				communicateUser2.setStatus(1);
				communicateService.updateCommunicate(communicateUser2);
			}
		}

	}




}
