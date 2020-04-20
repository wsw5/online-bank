package com.cs.online_bank.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cs.online_bank.admin.model.StoreCard;
@Mapper
public interface StoreMapper {
	
	public List<StoreCard> findByName(String userName);
	public Map<String, Object> findMessage(String cardNumber);
	public void update(StoreCard storeCard);
}
