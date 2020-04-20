package com.cs.online_bank.admin.service;

import java.util.List;
import java.util.Map;

import com.cs.online_bank.admin.model.StoreCard;

public interface StoreService {
	public List<StoreCard> findByName(String userName);
	public Map<String, Object> findMessage(String cardNumber);
	public void update(StoreCard storeCard);
	public void transfer(StoreCard storeCard1,StoreCard storeCard2,String money);
}
