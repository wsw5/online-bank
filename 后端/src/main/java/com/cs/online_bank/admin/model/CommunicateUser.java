package com.cs.online_bank.admin.model;

import java.util.Date;

public class CommunicateUser {
	private Integer id;//id
	private Integer userName;//userName
	private String name;//主题
	private String imageUrl;//主题图片地址
	private String content;//内容
	private Date beginTime;//发表时间
	private Date endTime;//结束时间
	private String count;//点击次数
	private Integer status;//状态
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public Integer getUserName() {
		return userName;
	}
	public void setUserName(Integer userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CommunicateUser [id=" + id + ", userName=" + userName + ", name=" + name + ", imageUrl=" + imageUrl
				+ ", content=" + content + ", beginTime=" + beginTime + ", endTime=" + endTime + ", count=" + count
				+ ", status=" + status + "]";
	}
	
	
	
}
