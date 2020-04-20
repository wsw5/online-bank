package com.cs.online_bank.admin.model;

public class Report {
	private String cardNumber;
	private String name;
	private String idNumber;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	@Override
	public String toString() {
		return "Report [cardNumber=" + cardNumber + ", name=" + name + ", idNumber=" + idNumber + ", password="
				+ password + "]";
	}
	
}
