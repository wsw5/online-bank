package com.cs.online_bank.admin.job;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.transaction.annotation.Transactional;

import com.cs.online_bank.admin.model.FundDayWorth;
import com.cs.online_bank.admin.model.FundDeal;
import com.cs.online_bank.admin.model.FundProduct;
import com.cs.online_bank.admin.model.Redeem;
import com.cs.online_bank.admin.model.StoreCard;
import com.cs.online_bank.admin.service.FundService;
import com.cs.online_bank.admin.service.StoreService;
import com.mysql.fabric.xmlrpc.base.Array;

@Transactional
public class MyJob2 extends QuartzJobBean{
	@Autowired 
	private FundService fundService;
	@Autowired
	private StoreService storeService;
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		//当前时间
		Date date=new Date();
		List<FundDayWorth> mession1 = mession1(date);
		mession2(date,mession1);

	}
	public List<FundDayWorth> mession1(Date date) {
		//任务一设置每日的基金净值以及购买时的净值
		List<FundProduct> findAll = fundService.findAll();
		List<FundDeal> findFundDeal = fundService.findFundDeal();
		List<FundDayWorth> list =new ArrayList<>();
		if (findAll!=null) {
			for (FundProduct fundProduct : findAll) {
				//随机生成合理的净值
				Random random=new Random();
				double nextDouble = random.nextDouble()*2+0.3;
				String format = String.format("%.2f", nextDouble);
				fundProduct.setFundDayWorth(format);
				fundProduct.setWorthDate(date);
				fundService.updateFundProduct(fundProduct);
				System.out.println(fundProduct);
				FundDayWorth dayWorth=new FundDayWorth();
				dayWorth.setfId(fundProduct.getId());
				dayWorth.setNetWorth(format);
				dayWorth.setDate(date);
				list.add(dayWorth);
				fundService.saveFundDayWorth(dayWorth);
				if (findFundDeal!=null) {
					for (FundDeal fundDeal : findFundDeal) {
						if (fundDeal.getDate().getDay()==date.getDay()) {
							fundDeal.setFundDayWorth(format);
							double allMoney = Double.parseDouble(fundDeal.getAllMoney());
							Double subscriptionMoney=allMoney/(1+Double.parseDouble(fundDeal.getSubscriptionRate())*0.01);
							Double dshare=subscriptionMoney/nextDouble;
							String share = String.format("%.2F", dshare);
							fundDeal.setShare(share);
						}
					}
				}

			}
		}
		System.out.println(list);
		return list;
	}

	public void mession2(Date date,List<FundDayWorth> list) {
		//任务二根据赎回信息，设置赎回信息
		List<Redeem> findRedeem = fundService.findRedeem();
		if (!(findRedeem==null)) {
			Double fundDayWorth=0.0;
			for (Redeem redeem : findRedeem) {
				if (redeem.getDate().getDay()==date.getDay()) {
					FundDeal fundDeal = fundService.findFundDealById(redeem.getId());
					for (FundDayWorth fundDayWorth1 : list) {
						if (fundDayWorth1.getfId()==fundDeal.getfId()) {
							fundDayWorth=Double.parseDouble(fundDayWorth1.getNetWorth());
						}
					}
					//赎回总额
					String share = redeem.getShare();
					Double allMoney=Double.parseDouble(share)*fundDayWorth;
					//赎回率0.5%
					Double money=allMoney*(1-0.005);
					redeem.setStatus(1);
					redeem.setCardNumber(fundDeal.getCardNumber());
					redeem.setRedeemMoney(String.valueOf(money));
				}
			}
		}
		mession3(date);

	}

	public void mession3(Date date) {
		//开始赎回
		List<Redeem> findRedeemtranfer = fundService.findRedeemtranfer();
		if (findRedeemtranfer!=null) {
			for (Redeem redeem : findRedeemtranfer) {
				Date date2 = redeem.getDate();
				if ((date2.getDay()-date.getDay())==1) {
					String cardNumber = redeem.getCardNumber();
					Map<String, Object> findMessage = storeService.findMessage(cardNumber);
					double parseDouble = Double.parseDouble(findMessage.get("money").toString());
					double money = parseDouble+Double.parseDouble(redeem.getRedeemMoney());
					StoreCard storeCard=new StoreCard();
					storeCard.setCardNumber(cardNumber);
					storeCard.setMoney(String.valueOf(money));
					storeService.update(storeCard);
				}
			}
		}
	}

}
