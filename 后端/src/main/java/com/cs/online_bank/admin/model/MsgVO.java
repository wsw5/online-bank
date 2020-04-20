package com.cs.online_bank.admin.model;
public class MsgVO {
	//用户id
	private String userName;
	//房间号
	private Integer cId;
	//发表消息
	private String msg;
	//在线人数
	private long count;
	//身份
	private Integer role;
	

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "MsgVO [userName=" + userName + ", cId=" + cId + ", msg=" + msg + ", count=" + count + ", role=" + role
				+ "]";
	}

	

	
	
}
