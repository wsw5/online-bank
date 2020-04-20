package com.cs.online_bank.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cs.online_bank.admin.model.FundDayWorth;
import com.cs.online_bank.admin.model.FundDeal;
import com.cs.online_bank.admin.model.FundProduct;
import com.cs.online_bank.admin.model.Redeem;
@Mapper
public interface FundMapper {
	public List<FundProduct> findAll();
	
	public void saveFund(FundDeal fundDeal);
	
	public void saveFundDayWorth(FundDayWorth fundDayWorth);
	
	public void updateFundProduct(FundProduct fundProduct);
	public List<FundDeal> findFundDeal();
	
	public List<Redeem> findRedeem();
	
	public void saveRedeem(Redeem redeem);
	
	public FundDeal findFundDealById(Integer id);
	
	public List<Redeem> findRedeemtranfer();
}
