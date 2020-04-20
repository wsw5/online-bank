package com.cs.online_bank.admin.model;

public class LoanProve {
	private Integer id;//id主键
	private Integer bId;//银行贷款申请id
	private String prove;//贷款证明，以图片url显示
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getbId() {
		return bId;
	}
	public void setbId(Integer bId) {
		this.bId = bId;
	}
	public String getProve() {
		return prove;
	}
	public void setProve(String prove) {
		this.prove = prove;
	}
	@Override
	public String toString() {
		return "LoanProve [id=" + id + ", bId=" + bId + ", prove=" + prove + "]";
	}
	
}
