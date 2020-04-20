package com.cs.online_bank.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.online_bank.admin.dao.StoreMapper;
import com.cs.online_bank.admin.model.StoreCard;
import com.cs.online_bank.admin.service.StoreService;
@Service
@Transactional
public class StoreServiceImpl implements StoreService{
	@Autowired
	private StoreMapper storeMapper;
	@Override
	public List<StoreCard> findByName(String userName) {
		return storeMapper.findByName(userName);
	}
	@Override
	public Map<String, Object> findMessage(String cardNumber) {
		return storeMapper.findMessage(cardNumber);
	}

	@Override
	public void transfer(StoreCard storeCard1,StoreCard storeCard2, String money) {
		Double newmoney1=Double.parseDouble(storeCard1.getMoney())-Double.parseDouble(money);
		storeCard1.setMoney(String.valueOf(newmoney1));
		storeMapper.update(storeCard1);
		
		Double newmoney2=Double.parseDouble(storeCard2.getMoney())+Double.parseDouble(money);
		storeCard2.setMoney(String.valueOf(newmoney2));
		storeMapper.update(storeCard2);
	}
	@Override
	public void update(StoreCard storeCard) {
		storeMapper.update(storeCard);
	}
	
	

}
