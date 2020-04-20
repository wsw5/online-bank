package com.cs.online_bank.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.online_bank.admin.dao.ManageMoneyMapper;
import com.cs.online_bank.admin.dao.StoreMapper;
import com.cs.online_bank.admin.model.ManageMoneyDeal;
import com.cs.online_bank.admin.model.ManageMoneyProduct;
import com.cs.online_bank.admin.model.StoreCard;
import com.cs.online_bank.admin.service.ManageMoneyService;
@Service
@Transactional
public class ManageMoneyServiceImpl implements ManageMoneyService{
	@Autowired
	private ManageMoneyMapper manageMoneyMapper;
	@Autowired
	private StoreMapper storeMapper;
	@Override
	public List<ManageMoneyProduct> findAll() {
		return manageMoneyMapper.findAll();
	}
	@Override
	public void save(ManageMoneyDeal manageMoneyDeal, StoreCard storeCard, String money) {
		System.out.println(manageMoneyDeal);
		manageMoneyMapper.save(manageMoneyDeal);
	 
		Double moneyNow=Double.parseDouble(storeCard.getMoney())-Double.parseDouble(money);
		storeCard.setMoney(String.valueOf(moneyNow));
		storeMapper.update(storeCard);
	}
	@Override
	public void updateProduct(ManageMoneyProduct manageMoneyProduct) {
		manageMoneyMapper.updateProduct(manageMoneyProduct);
	}
	@Override
	public List<ManageMoneyProduct> findDealAll() {
		return manageMoneyMapper.findDealAll();
	}
	@Override
	public void updateDeal(ManageMoneyDeal manageMoneyDeal) {
		manageMoneyMapper.updateDeal(manageMoneyDeal);
	}
	@Override
	public List<ManageMoneyDeal> findDeal(Integer id) {
		return manageMoneyMapper.findDeal(id);
	}

}
