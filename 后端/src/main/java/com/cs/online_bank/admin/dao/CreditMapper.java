package com.cs.online_bank.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cs.online_bank.admin.model.CreditUser;
import com.cs.online_bank.admin.model.Pay;
@Mapper
public interface CreditMapper {
	//根据名字查找所有信用卡包括账单
	public List<CreditUser> findByName(String userName);
	//根据卡号查找相关验证身份信息
	public Map<String, Object> findMessage(String cardNumber);
	//根据creditUser更新挂失状态
	public void updateReport(CreditUser creditUser);
	//根据id查找相关账单信息
	public Pay findById(Integer id);
	//根据pay更新账单信息以及状态
	public void update(Pay pay);
	//查找还未还清款的所有的账单详情
	public List<Pay> findAll();
}
