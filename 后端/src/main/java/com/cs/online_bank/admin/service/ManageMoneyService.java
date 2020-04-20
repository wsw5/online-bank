package com.cs.online_bank.admin.service;

import java.util.List;

import com.cs.online_bank.admin.model.ManageMoneyDeal;
import com.cs.online_bank.admin.model.ManageMoneyProduct;
import com.cs.online_bank.admin.model.StoreCard;

public interface ManageMoneyService {
	//查找所有理财产品
	public List<ManageMoneyProduct> findAll();
	//添加用户买入的理财产品
	public void save(ManageMoneyDeal manageMoneyDeal,StoreCard storeCard,String money);

	//截止期一到，修改产品状态
	public void updateProduct(ManageMoneyProduct manageMoneyProduct);

	//查找所有用户已买的理财产品
	public List<ManageMoneyProduct> findDealAll();

	//截止期一到，修改用户购买产品的状态,并退款
	public void updateDeal(ManageMoneyDeal manageMoneyDeal);

	public List<ManageMoneyDeal> findDeal(Integer id);
}
