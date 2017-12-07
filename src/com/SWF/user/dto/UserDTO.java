package com.SWF.user.dto;

import java.util.Date;

public class UserDTO {
	private String email;
	private String upw;
	private String umsg;
	private Date birth;
	private String gender;
	private String region;
	private Integer upoint;
	private String usecustomservice;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUmsg() {
		return umsg;
	}
	public void setUmsg(String umsg) {
		this.umsg = umsg;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Integer getUpoint() {
		return upoint;
	}
	public void setUpoint(Integer upoint) {
		this.upoint = upoint;
	}
	public String getUsecustomservice() {
		return usecustomservice;
	}
	public void setUsecustomservice(String usecustomservice) {
		this.usecustomservice = usecustomservice;
	}
	
	@Override
	public String toString() {
		return "UserDTO [email=" + email + ", upw=" + upw + ", umsg=" + umsg + ", birth=" + birth + ", gender=" + gender
				+ ", region=" + region + ", upoint=" + upoint + ", usecustomservice=" + usecustomservice + "]";
	}
	
}
