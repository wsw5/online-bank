package com.cs.online_bank.admin.model;

public class StoreCard {
	private Integer id;
	private String cardNumber;
	private String userName;
	private String money;
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
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "StoreCard [id=" + id + ", cardNumber=" + cardNumber + ", userName=" + userName + ", money=" + money
				+ ", status=" + status + ", password=" + password + "]";
	}
	
	
}
