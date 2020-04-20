package com.cs.online_bank.admin.model;

import java.util.Date;

public class FundDayWorth {
	private Integer id;
	private Integer fId;
	private String netWorth;
	private Date date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getfId() {
		return fId;
	}
	public void setfId(Integer fId) {
		this.fId = fId;
	}
	public String getNetWorth() {
		return netWorth;
	}
	public void setNetWorth(String netWorth) {
		this.netWorth = netWorth;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
