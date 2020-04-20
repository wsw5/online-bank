package com.cs.online_bank.admin.model;

import java.util.Date;

public class Redeem {
	private Integer id;//id
	private Integer pId;//基金申购id
	private String  share;//赎回份额
	private Date date;//赎回时间
	private Integer status;//状态
	private String CardNumber;
	private String redeemMoney;
	public String getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}
	public String getRedeemMoney() {
		return redeemMoney;
	}
	public void setRedeemMoney(String redeemMoney) {
		this.redeemMoney = redeemMoney;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getShare() {
		return share;
	}
	public void setShare(String share) {
		this.share = share;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
