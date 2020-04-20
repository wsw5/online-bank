package com.cs.online_bank.admin.model;

public class ManageMoneyDeal {
	private Integer id;//id主键
	private Integer mId;//理财产品id
	private Integer uId;//user id
	private String money;//投入的钱
	private String cardNumber;//投入的卡号，以便退回账户
	private String countMoney;//记录总计赚取得钱
	private Integer status;//状态,0表示已购买未计息，1表示正在计息，2表示计息期限已到，并已退回账户
	
	public String getCountMoney() {
		return countMoney;
	}
	public void setCountMoney(String countMoney) {
		this.countMoney = countMoney;
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
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ManageMoneyDeal [id=" + id + ", mId=" + mId + ", uId=" + uId + ", money=" + money + ", status=" + status
				+ "]";
	}
	
	
}
