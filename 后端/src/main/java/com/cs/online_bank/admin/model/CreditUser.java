package com.cs.online_bank.admin.model;

import java.util.List;

public class CreditUser {
	private Integer id;			//id
	private String cardNumber;	//卡号
	private Integer uId;		//uid
	private String avaliableCredit;//可用总额度
	private Integer status;		//状态
	private String password;
	private List<Pay> pays;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public List<Pay> getPays() {
		return pays;
	}
	public void setPays(List<Pay> pays) {
		this.pays = pays;
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

	public String getAvaliableCredit() {
		return avaliableCredit;
	}
	public void setAvaliableCredit(String avaliableCredit) {
		this.avaliableCredit = avaliableCredit;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CreditUser [id=" + id + ", cardNumber=" + cardNumber + ", uid=" + uId + ", avaliableCredit="
				+ avaliableCredit +", status=" + status + "]";
	}
	
}
