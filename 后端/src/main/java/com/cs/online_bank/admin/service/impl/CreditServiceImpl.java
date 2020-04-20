package com.cs.online_bank.admin.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.online_bank.admin.dao.CreditMapper;
import com.cs.online_bank.admin.dao.StoreMapper;
import com.cs.online_bank.admin.model.CreditUser;
import com.cs.online_bank.admin.model.Pay;
import com.cs.online_bank.admin.model.StoreCard;
import com.cs.online_bank.admin.service.CreditService;
@Service
@Transactional
public class CreditServiceImpl implements CreditService{
	@Autowired
	private CreditMapper creditMapper;
	
	@Autowired
	private StoreMapper storeMapper;
	
	@Override
	public Map<String, Object> findMessage(String cardNumber) {
		return creditMapper.findMessage(cardNumber);
	}
	@Override
	public void creditReport(CreditUser creditUser) {
		creditMapper.updateReport(creditUser);
	}
	@Override
	public List<CreditUser> findByName(String userName) {
		return creditMapper.findByName(userName);
	}
	@Override
	public void payBill(Pay pay, StoreCard storeCard) {
		//根据id查找账单信息
		Pay findById = creditMapper.findById(pay.getId());
		//获取未还与已还的数据并转换为double
		double paytotal = Double.parseDouble(findById.getPaytotal());
		double paied = Double.parseDouble(findById.getPaied());
		//获取还款金额
		double payMoney = Double.parseDouble(pay.getPaytotal());
		
		//卡一更新剩余未还
		Double payingmoney = paytotal-payMoney;
		//更新已还
		Double paiedmoney = paied+payMoney;
		//并set到pay对象里面用于更新
		findById.setPaytotal(String.valueOf(payingmoney));
		findById.setPaied(String .valueOf(paiedmoney));
		
		//卡二更新余额
		Double balance=Double.parseDouble(storeCard.getMoney())-payMoney;
		//并set到storeCard对象里面用于更新
		storeCard.setMoney(String .valueOf(balance));
		//剩余未还是否等于0，若等于0则表示还完，状态设为1
		if (payingmoney==0) {
			findById.setStatus(1);
			creditMapper.update(findById);
			storeMapper.update(storeCard);
		}
		creditMapper.update(findById);
		storeMapper.update(storeCard);
	}
	@Override
	public List<Pay> findAll() {
		
		return creditMapper.findAll();
	}
	@Override
	public void update(Pay pay) {
		creditMapper.update(pay);
	}
	
	
	

}
