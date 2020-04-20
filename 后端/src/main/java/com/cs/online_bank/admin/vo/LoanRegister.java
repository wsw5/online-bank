package com.cs.online_bank.admin.vo;

public class LoanRegister {
	private Integer uId;
	private String realName;
	private String idNumber;
	private String loadType;
	private String money;
	private String payType;
	private String payLimit;
	private String use;
	private String loanAmount;
	
	
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getPayLimit() {
		return payLimit;
	}
	public void setPayLimit(String payLimit) {
		this.payLimit = payLimit;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getLoadType() {
		return loadType;
	}
	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}
	@Override
	public String toString() {
		return "LoanRegister [uId=" + uId + ", realName=" + realName + ", idNumber=" + idNumber + ", loadType="
				+ loadType + ", money=" + money + ", payType=" + payType + ", payLimit=" + payLimit + ", use=" + use
				+ ", loanAmount=" + loanAmount + "]";
	}
	
	
	
	
}
