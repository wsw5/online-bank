package com.cs.online_bank.admin.model;
//先息后本

import java.util.Date;

public class InterestFirst {
	private Integer id;//id主键
	private Integer bId;//属于该类型的贷款记录id
	private Integer payType;//还款类型(1：先息后本，2：等额本息，3：一次性还本付息)
	private double deductInterest;//已扣除的利息
	private String dayOfOutstanding;//超过还款日的天数
	private double shouldAlsoInterest;//超过天数的利息
	private double shouldAlsoTotal;//应还总额
	private Integer whetherPay;//是否已还清
	private double rate;//计息利率
	private Date payDate;//还清贷款日期
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
	public double getDeductInterest() {
		return deductInterest;
	}
	public void setDeductInterest(double deductInterest) {
		this.deductInterest = deductInterest;
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
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	@Override
	public String toString() {
		return "InterestFirst [id=" + id + ", bId=" + bId + ", payType=" + payType + ", deductInterest="
				+ deductInterest + ", dayOfOutstanding=" + dayOfOutstanding + ", shouldAlsoInterest="
				+ shouldAlsoInterest + ", shouldAlsoTotal=" + shouldAlsoTotal + ", whetherPay=" + whetherPay + ", rate="
				+ rate + ", payDate=" + payDate + "]";
	}
	
}
