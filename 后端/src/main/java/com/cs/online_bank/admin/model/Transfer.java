package com.cs.online_bank.admin.model;

public class Transfer {
	private String cardNumber1;
	private String idNumber;
	private String cardNumber2;
	private String name;
	private String money;
	private String password;
	public String getCardNumber1() {
		return cardNumber1;
	}
	public void setCardNumber1(String cardNumber1) {
		this.cardNumber1 = cardNumber1;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getCardNumber2() {
		return cardNumber2;
	}
	public void setCardNumber2(String cardNumber2) {
		this.cardNumber2 = cardNumber2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Transfer [cardNumber1=" + cardNumber1 + ", idNumber=" + idNumber + ", cardNumber2=" + cardNumber2
				+ ", name=" + name + ", money=" + money + ", password=" + password + "]";
	}
	
}
