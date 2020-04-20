package com.cs.online_bank.admin.model;

import java.util.Date;

public class Loan {
	private Integer id;//id主键
	private Integer uId;//用户id
	private String money;//贷款金额
	private String loanAmount;//贷款账户
	private Integer loanType;//贷款类型（1:委托贷款，2：信用贷款，3：担保贷款，4：票据贴现）
	private String use;//用途
	private String payType;//还款类型（1：先息后本，2：等额本息，3：一次性还本付息）
	private String payLimit;//还款期限
	private Date loanDate;//借款时间，也就是审核通过后放款的时间
	private Integer whetherLoan;//是否已放款
	private Integer whetherPay;//是否已还清;
	private Integer managerId;//受理经理id
	private Integer whetherProve;//是否已提交证明
	private Integer status;//审核状态（0:正在审核，1：审核通过，2：审核未通过）
	private String reason;//审核原因
	private User user;
	private LoanProve loanProve;
	
	
	public LoanProve getLoanProve() {
		return loanProve;
	}
	public void setLoanProve(LoanProve loanProve) {
		this.loanProve = loanProve;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getWhetherProve() {
		return whetherProve;
	}
	public void setWhetherProve(Integer whetherProve) {
		this.whetherProve = whetherProve;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public Integer getLoanType() {
		return loanType;
	}
	public void setLoanType(Integer loanType) {
		this.loanType = loanType;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPayLimit() {
		return payLimit;
	}
	public void setPayLimit(String payLimit) {
		this.payLimit = payLimit;
	}
	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	public Integer getWhetherLoan() {
		return whetherLoan;
	}
	public void setWhetherLoan(Integer whetherLoan) {
		this.whetherLoan = whetherLoan;
	}
	public Integer getWhetherPay() {
		return whetherPay;
	}
	public void setWhetherPay(Integer whetherPay) {
		this.whetherPay = whetherPay;
	}
	@Override
	public String toString() {
		return "Loan [id=" + id + ", uId=" + uId + ", money=" + money + ", loanAmount=" + loanAmount + ", loanType="
				+ loanType + ", use=" + use + ", payType=" + payType + ", payLimit=" + payLimit + ", loanDate="
				+ loanDate + ", whetherLoan=" + whetherLoan + ", whetherPay=" + whetherPay + ", managerId=" + managerId
				+ ", whetherProve=" + whetherProve + ", status=" + status + ", reason=" + reason + ", user=" + user
				+ "]";
	}
	
	
}
