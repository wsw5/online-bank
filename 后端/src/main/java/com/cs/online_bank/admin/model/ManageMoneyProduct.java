package com.cs.online_bank.admin.model;

import java.util.Date;
import java.util.List;

public class ManageMoneyProduct {
	private Integer id;//id主键
	private String manageMoneyName;//理财产品名字
	private String time;//期限
	private String beginMoney;//起购金额
	private Date endTime;//截止时间
	private String rate;//比率
	private Integer status;//状态:0表示已投未计息，1表示正在计息期间不能购买
	private List<ManageMoneyDeal> manageMoneyDeals;
	
	public String getBeginMoney() {
		return beginMoney;
	}
	public void setBeginMoney(String beginMoney) {
		this.beginMoney = beginMoney;
	}
	public List<ManageMoneyDeal> getManageMoneyDeals() {
		return manageMoneyDeals;
	}
	public void setManageMoneyDeals(List<ManageMoneyDeal> manageMoneyDeals) {
		this.manageMoneyDeals = manageMoneyDeals;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getManageMoneyName() {
		return manageMoneyName;
	}
	public void setManageMoneyName(String manageMoneyName) {
		this.manageMoneyName = manageMoneyName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ManageMoneyProduct [id=" + id + ", manageMoneyName=" + manageMoneyName + ", time=" + time + ", endTime="
				+ endTime + ", rate=" + rate + ", status=" + status + ", manageMoneyDeals=" + manageMoneyDeals + "]";
	}
	
	
	
}

