package com.cs.online_bank.admin.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.online_bank.admin.dao.FundMapper;
import com.cs.online_bank.admin.dao.StoreMapper;
import com.cs.online_bank.admin.model.FundDayWorth;
import com.cs.online_bank.admin.model.FundDeal;
import com.cs.online_bank.admin.model.FundProduct;
import com.cs.online_bank.admin.model.Redeem;
import com.cs.online_bank.admin.model.StoreCard;
import com.cs.online_bank.admin.service.FundService;

@Service
public class FundServiceImpl implements FundService{
	@Autowired
	private FundMapper fundMapper;
	@Autowired
	private StoreMapper storeMapper;
	@Override
	public List<FundProduct> findAll() {
		return fundMapper.findAll();
	}
	@Override
	public void saveFund(FundDeal fundDeal) {
		//时间的处理
		Date date = fundDeal.getDate();
		long nd = 1000 * 24 * 60 * 60;
		System.out.println(date.getTime()+nd);
		if (date.getHours()>15) {
			long newTime=date.getTime()+nd;
			fundDeal.setDate(new Date(newTime));
		}
		//金额处理
		String cardNumber = fundDeal.getCardNumber();
		Map<String, Object> findMessage = storeMapper.findMessage(cardNumber);
		String oldMoney=findMessage.get("money").toString();
		Double newMoney=Double.parseDouble(oldMoney)-Double.parseDouble(fundDeal.getAllMoney());
		StoreCard storeCard=new StoreCard();
		storeCard.setCardNumber(cardNumber);
		storeCard.setMoney(String.valueOf(newMoney));
		storeMapper.update(storeCard);
		fundMapper.saveFund(fundDeal);
	}
	@Override
	public void saveFundDayWorth(FundDayWorth fundDayWorth) {
		fundMapper.saveFundDayWorth(fundDayWorth);
	}
	@Override
	public void updateFundProduct(FundProduct fundProduct) {
		fundMapper.updateFundProduct(fundProduct);
	}
	@Override
	public List<FundDeal> findFundDeal() {
		return fundMapper.findFundDeal();
	}
	@Override
	public List<Redeem> findRedeem() {
		return fundMapper.findRedeem();
	}
	@Override
	public void saveRedeem(Redeem redeem) {
		Date date = redeem.getDate();
		long nd = 1000 * 24 * 60 * 60;
		if (date.getHours()>15) {
			long time=date.getTime()+nd;
			Date date2=new Date(time);
			redeem.setDate(date2);
		}
	}
	@Override
	public FundDeal findFundDealById(Integer id) {
		return fundMapper.findFundDealById(id);
	}
	@Override
	public List<Redeem> findRedeemtranfer() {
		
		return fundMapper.findRedeemtranfer();
	}
	
}
