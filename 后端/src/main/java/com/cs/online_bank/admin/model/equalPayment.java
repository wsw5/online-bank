package com.cs.online_bank.admin.model;
//等额付息

import java.util.Date;

public class equalPayment {
	private Integer id;//id主键
	private Integer bId;//属于该类型的贷款记录id
	private Integer payType;//还款类型(1：先息后本，2：等额本息，3：一次性还本付息)
	private Date payDate;//还清贷款的日期
	private double payMonthMoney;//每月应还的本息
	private String dayOfOutstanding;//超过还款日期的天数
	private double shouldAlsoInterest;//应还的利息
	private double shouldAlsoTotal;//本月应还总额
	private Integer whetherPay;//本月是否已还
	private double rate;//贷款利息
	private String remark;//备注
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getbId() {
		return bId;
	}
	public void setbId(Integer bId) {
		this.bId = bId;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public double getPayMonthMoney() {
		return payMonthMoney;
	}
	public void setPayMonthMoney(double payMonthMoney) {
		this.payMonthMoney = payMonthMoney;
	}
	public String getDayOfOutstanding() {
		return dayOfOutstanding;
	}
	public void setDayOfOutstanding(String dayOfOutstanding) {
		this.dayOfOutstanding = dayOfOutstanding;
	}
	public double getShouldAlsoInterest() {
		return shouldAlsoInterest;
	}
	public void setShouldAlsoInterest(double shouldAlsoInterest) {
		this.shouldAlsoInterest = shouldAlsoInterest;
	}
	public double getShouldAlsoTotal() {
		return shouldAlsoTotal;
	}
	public void setShouldAlsoTotal(double shouldAlsoTotal) {
		this.shouldAlsoTotal = shouldAlsoTotal;
	}
	public Integer getWhetherPay() {
		return whetherPay;
	}
	public void setWhetherPay(Integer whetherPay) {
		this.whetherPay = whetherPay;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "equalPayment [id=" + id + ", bId=" + bId + ", payType=" + payType + ", payDate=" + payDate
				+ ", payMonthMoney=" + payMonthMoney + ", dayOfOutstanding=" + dayOfOutstanding
				+ ", shouldAlsoInterest=" + shouldAlsoInterest + ", shouldAlsoTotal=" + shouldAlsoTotal
				+ ", whetherPay=" + whetherPay + ", rate=" + rate + ", remark=" + remark + "]";
	}
	
}
