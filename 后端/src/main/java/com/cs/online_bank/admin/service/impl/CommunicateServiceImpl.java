package com.cs.online_bank.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.online_bank.admin.dao.CommunicateMapper;
import com.cs.online_bank.admin.model.Communicate;
import com.cs.online_bank.admin.model.CommunicateUser;
import com.cs.online_bank.admin.service.CommunicateService;

@Service
@Transactional
public class CommunicateServiceImpl implements CommunicateService{
	@Autowired
	private CommunicateMapper communicateMapper;
	
	@Override
	public void saveCommunicate(CommunicateUser communicateUser) {
		communicateUser.setStatus(0);
		long beginTime = communicateUser.getBeginTime().getTime();
		long time=30*24*60*60*1000;
		long endTime=beginTime-time;
		Date date=new Date(endTime);
		communicateUser.setEndTime(date);
		communicateUser.setCount("0");
		communicateMapper.saveCommunicate(communicateUser);
	}
	@Override
	public void updateCommunicate(CommunicateUser communicateUser) {
		long oldCount=Long.parseLong(communicateUser.getCount());
		communicateUser.setCount(String.valueOf(oldCount+1));
		communicateMapper.updateCommunicate(communicateUser);
	}
	@Override
	public List<Communicate> findCommunicate() {
		return communicateMapper.findCommunicate();
	}
	
	
}
