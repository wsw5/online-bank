package com.cs.online_bank.admin.model;
//一次性还本付息

import java.util.Date;

public class Repayment {
	private Integer id;//id主键
	private Integer bId;//属于该类型的贷款记录id
	private Integer payType;//还款类型(1：先息后本，2：等额本息，3：一次性还本付息)
	private double notDeductInterest;//还未扣除的利息
	private double dayOfOutstanding;//超过到期的天数
	private double shouldAlsoInterest;//超过天数所产生的利息
	private double shouldAlsoTotal;//应还总额
	private Integer  whetherPay;//是否已还清
	private Date payDate;//还清日期
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
	public double getNotDeductInterest() {
		return notDeductInterest;
	}
	public void setNotDeductInterest(double notDeductInterest) {
		this.notDeductInterest = notDeductInterest;
	}
	public double getDayOfOutstanding() {
		return dayOfOutstanding;
	}
	public void setDayOfOutstanding(double dayOfOutstanding) {
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
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	@Override
	public String toString() {
		return "Repayment [id=" + id + ", bId=" + bId + ", payType=" + payType + ", notDeductInterest="
				+ notDeductInterest + ", dayOfOutstanding=" + dayOfOutstanding + ", shouldAlsoInterest="
				+ shouldAlsoInterest + ", shouldAlsoTotal=" + shouldAlsoTotal + ", whetherPay=" + whetherPay
				+ ", payDate=" + payDate + "]";
	}
	
}
