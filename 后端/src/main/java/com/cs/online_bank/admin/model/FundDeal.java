package com.cs.online_bank.admin.model;

import java.util.Date;

public class FundDeal {
	private Integer id;
	private Integer fId;//基金id
	private Integer uId;//用户id
	private String fundDayWorth;//申购日基金净值
	private String allMoney;//申购总额
	private String subscriptionRate;//申购率
	private Date date;
	private String cardNumber;//卡号
	private String share;//含有份额
	private Integer status;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getFundDayWorth() {
		return fundDayWorth;
	}
	public void setFundDayWorth(String fundDayWorth) {
		this.fundDayWorth = fundDayWorth;
	}
	public String getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(String allMoney) {
		this.allMoney = allMoney;
	}
	public String getSubscriptionRate() {
		return subscriptionRate;
	}
	public void setSubscriptionRate(String subscriptionRate) {
		this.subscriptionRate = subscriptionRate;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getShare() {
		return share;
	}
	public void setShare(String share) {
		this.share = share;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
