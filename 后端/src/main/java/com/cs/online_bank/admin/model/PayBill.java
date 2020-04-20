package com.cs.online_bank.admin.model;

public class PayBill {
	private Integer id;
	
	private String cardNumber1;//需还款的卡号
	private String cardNumber2;//还款的卡号
	private String money;//还款金额
	private String password;//卡二密码
	public String getCardNumber1() {
		return cardNumber1;
	}
	public void setCardNumber1(String cardNumber1) {
		this.cardNumber1 = cardNumber1;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCardNumber2() {
		return cardNumber2;
	}
	public void setCardNumber2(String cardNumber2) {
		this.cardNumber2 = cardNumber2;
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
		return "PayBill [cardNumber1=" + cardNumber1 + ", cardNumber2=" + cardNumber2 + ", money=" + money
				+ ", password=" + password + "]";
	}
	
}
