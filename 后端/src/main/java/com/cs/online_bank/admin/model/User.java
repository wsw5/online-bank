package com.cs.online_bank.admin.model;
public class User {
	private int uId;
	private String userName;
	private String password;
	private String salt;
	private String realName;
	private String idNumber;
	private String phoneNumber;
	private String address;
	private String email;
	private Integer age;
	private Integer status;
	private Integer role;
	private String emergencyOneName;
	private String emergencyOnePhone;
	private String emergencyOneAddress;
	private String emergencyOneIdNumber;
	private String emergencyTwoName;
	private String emergencyTwoPhone;
	private String emergencyTwoAddress;
	private String emergencyTwoIdNumber;
	
	public String getEmergencyOneAddress() {
		return emergencyOneAddress;
	}
	public void setEmergencyOneAddress(String emergencyOneAddress) {
		this.emergencyOneAddress = emergencyOneAddress;
	}
	public String getEmergencyOneIdNumber() {
		return emergencyOneIdNumber;
	}
	public void setEmergencyOneIdNumber(String emergencyOneIdNumber) {
		this.emergencyOneIdNumber = emergencyOneIdNumber;
	}
	public String getEmergencyTwoAddress() {
		return emergencyTwoAddress;
	}
	public void setEmergencyTwoAddress(String emergencyTwoAddress) {
		this.emergencyTwoAddress = emergencyTwoAddress;
	}
	public String getEmergencyTwoIdNumber() {
		return emergencyTwoIdNumber;
	}
	public void setEmergencyTwoIdNumber(String emergencyTwoIdNumber) {
		this.emergencyTwoIdNumber = emergencyTwoIdNumber;
	}
	public String getEmergencyOneName() {
		return emergencyOneName;
	}
	public void setEmergencyOneName(String emergencyOneName) {
		this.emergencyOneName = emergencyOneName;
	}
	public String getEmergencyOnePhone() {
		return emergencyOnePhone;
	}
	public void setEmergencyOnePhone(String emergencyOnePhone) {
		this.emergencyOnePhone = emergencyOnePhone;
	}
	public String getEmergencyTwoName() {
		return emergencyTwoName;
	}
	public void setEmergencyTwoName(String emergencyTwoName) {
		this.emergencyTwoName = emergencyTwoName;
	}
	public String getEmergencyTwoPhone() {
		return emergencyTwoPhone;
	}
	public void setEmergencyTwoPhone(String emergencyTwoPhone) {
		this.emergencyTwoPhone = emergencyTwoPhone;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public User() {
		super();
	}
	public User(int uId, String userName, String password, String realName, String idNumber, String phoneNumber,
			String address, String email) {
		super();
		this.uId = uId;
		this.userName = userName;
		this.password = password;
		this.realName = realName;
		this.idNumber = idNumber;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", userName=" + userName + ", password=" + password + ", salt=" + salt
				+ ", realName=" + realName + ", idNumber=" + idNumber + ", phoneNumber=" + phoneNumber + ", address="
				+ address + ", email=" + email + ", age=" + age + ", status=" + status + ", role=" + role
				+ ", emergencyOneName=" + emergencyOneName + ", emergencyOnePhone=" + emergencyOnePhone
				+ ", emergencyOneAddress=" + emergencyOneAddress + ", emergencyOneIdNumber=" + emergencyOneIdNumber
				+ ", emergencyTwoName=" + emergencyTwoName + ", emergencyTwoPhone=" + emergencyTwoPhone
				+ ", emergencyTwoAddress=" + emergencyTwoAddress + ", emergencyTwoIdNumber=" + emergencyTwoIdNumber
				+ "]";
	}
	
	
	
}
