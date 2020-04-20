package com.cs.online_bank.admin.model;

public class ManageMoneyRegister {
	private Integer mid;//理财产品id
	private String userName;
	private String realName;
	private String idNumber;
	private String money;
	private String cardNumber;
	private String password;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ManageMoneyRegister [mid=" + mid + ", userName=" + userName + ", realName=" + realName + ", idNumber="
				+ idNumber + ", money=" + money + ", cardNumber=" + cardNumber + ", password=" + password + "]";
	}
	

}
