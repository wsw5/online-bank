package com.cs.online_bank.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cs.online_bank.admin.model.ManageMoneyDeal;
import com.cs.online_bank.admin.model.ManageMoneyProduct;

@Mapper
public interface ManageMoneyMapper {
	public List<ManageMoneyProduct> findAll();
	public void save(ManageMoneyDeal manageMoneyDeal);
	public void updateProduct(ManageMoneyProduct manageMoneyProduct);
	public List<ManageMoneyProduct> findDealAll();
	public void updateDeal(ManageMoneyDeal manageMoneyDeal);
	public List<ManageMoneyDeal> findDeal(Integer id);
}
