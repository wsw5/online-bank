package com.cs.online_bank.admin.model;

import java.util.Date;

public class Pay {
	private Integer id;//id
	private Integer cId;//cid
	private String bill;//账单
	private String interest;//利息
	private Date payday;//还款日
	private String paied;//已经换了
	private String paytotal;//还应还
	private Integer status;//判断是否已还完，0表示未还清，1表示还清
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public String getBill() {
		return bill;
	}
	public void setBill(String bill) {
		this.bill = bill;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public Date getPayday() {
		return payday;
	}
	public void setPayday(Date payday) {
		this.payday = payday;
	}
	public String getPaied() {
		return paied;
	}
	public void setPaied(String paied) {
		this.paied = paied;
	}
	public String getPaytotal() {
		return paytotal;
	}
	public void setPaytotal(String paytotal) {
		this.paytotal = paytotal;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Pay [id=" + id + ", cId=" + cId + ", bill=" + bill + ", interest=" + interest + ", payday=" + payday
				+ ", paied=" + paied + ", paytotal=" + paytotal + ", status=" + status + "]";
	}
	
}
