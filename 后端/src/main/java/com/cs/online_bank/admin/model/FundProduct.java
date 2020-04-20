package com.cs.online_bank.admin.model;

import java.util.Date;

public class FundProduct {
	private Integer id;//id
	private String code;//代码
	private String fundName;//基金名称
	private String rateYear;//近一年比率
	private Integer currency;//币种
	private String kind;//产品种类
	private String type;//产品类型
	private Date beginTime;//发行时间
	private String beginMoney;//发行价
	private String fundDayWorth;//份额
	private Date worthDate;//份额日期
	private Integer status;
	
	
	public String getFundDayWorth() {
		return fundDayWorth;
	}
	public void setFundDayWorth(String fundDayWorth) {
		this.fundDayWorth = fundDayWorth;
	}
	public Date getWorthDate() {
		return worthDate;
	}
	public void setWorthDate(Date worthDate) {
		this.worthDate = worthDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public String getRateYear() {
		return rateYear;
	}
	public void setRateYear(String rateYear) {
		this.rateYear = rateYear;
	}
	public Integer getCurrency() {
		return currency;
	}
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	public String getBeginMoney() {
		return beginMoney;
	}
	public void setBeginMoney(String beginMoney) {
		this.beginMoney = beginMoney;
	}
	
	
}
