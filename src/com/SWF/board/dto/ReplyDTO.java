package com.SWF.board.dto;

import java.util.Date;

public class ReplyDTO {
	
	private int bno;
	private int rno;
	private String rwriter;
	private String rcont;
	private Date rregdt;
	private String rhidden;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRwriter() {
		return rwriter;
	}
	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}
	public String getRcont() {
		return rcont;
	}
	public void setRcont(String rcont) {
		this.rcont = rcont;
	}
	public Date getRregdt() {
		return rregdt;
	}
	public void setRregdt(Date rregdt) {
		this.rregdt = rregdt;
	}
	public String getRhidden() {
		return rhidden;
	}
	public void setRhidden(String rhidden) {
		this.rhidden = rhidden;
	}

	@Override
	public String toString() {
		return "ReplyDTO [bno=" + bno + ", rno=" + rno + ", rwriter=" + rwriter + ", rcont=" + rcont + ", rregdt="
				+ rregdt + ", rhidden=" + rhidden + "]";
	}
	
}
