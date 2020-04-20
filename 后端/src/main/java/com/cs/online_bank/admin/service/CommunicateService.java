package com.cs.online_bank.admin.service;

import java.util.List;

import com.cs.online_bank.admin.model.Communicate;
import com.cs.online_bank.admin.model.CommunicateUser;

public interface CommunicateService {
	public List<Communicate> findCommunicate();
	
	public void saveCommunicate(CommunicateUser communicateUser);
	
	public void updateCommunicate(CommunicateUser communicateUser);
}
