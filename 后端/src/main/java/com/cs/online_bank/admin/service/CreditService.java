package com.cs.online_bank.admin.service;

import java.util.List;
import java.util.Map;

import com.cs.online_bank.admin.model.CreditUser;
import com.cs.online_bank.admin.model.Pay;
import com.cs.online_bank.admin.model.PayBill;
import com.cs.online_bank.admin.model.StoreCard;

public interface CreditService {
	public List<CreditUser> findByName(String userName);
	public Map<String, Object> findMessage(String cardNumber);
	public void creditReport(CreditUser creditUser);
	public void payBill(Pay pay,StoreCard storeCard);
	public List<Pay> findAll();
	public void update(Pay pay);
}
