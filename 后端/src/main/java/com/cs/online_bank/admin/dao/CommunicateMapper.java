package com.cs.online_bank.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cs.online_bank.admin.model.Communicate;
import com.cs.online_bank.admin.model.CommunicateUser;

@Mapper
public interface CommunicateMapper {
	public List<Communicate> findCommunicate();
	
	public void saveCommunicate(CommunicateUser communicateUser);
	
	public void updateCommunicate(CommunicateUser communicateUser);
}
