package com.SWF.user.dto;

import java.util.Date;

public class AttendenceDTO {
	
	private String email;
	private Date logindt;
	private int loginseq;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLogindt() {
		return logindt;
	}
	public void setLogindt(Date logindt) {
		this.logindt = logindt;
	}
	public int getLoginseq() {
		return loginseq;
	}
	public void setLoginseq(int loginseq) {
		this.loginseq = loginseq;
	}
	
	@Override
	public String toString() {
		return "AttendenceDTO [email=" + email + ", logindt=" + logindt + ", loginseq=" + loginseq + "]";
	}
	
}
