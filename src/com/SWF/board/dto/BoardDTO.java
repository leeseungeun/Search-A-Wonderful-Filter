package com.SWF.board.dto;

import java.util.Date;

public class BoardDTO {

	private int bno;
	private String bdiv;
	private String btitle;
	private String bwriter;
	private String bcont;
	private Date bregdt;
	private Date bupdt;
	private int viewcnt;
	private int replycnt;
	private String bhidden;

	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBdiv() {
		return bdiv;
	}
	public void setBdiv(String bdiv) {
		this.bdiv = bdiv;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBcont() {
		return bcont;
	}
	public void setBcont(String bcont) {
		this.bcont = bcont;
	}
	public Date getBregdt() {
		return bregdt;
	}
	public void setBregdt(Date bregdt) {
		this.bregdt = bregdt;
	}
	public Date getBupdt() {
		return bupdt;
	}
	public void setBupdt(Date bupdt) {
		this.bupdt = bupdt;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public int getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}
	public String getBhidden() {
		return bhidden;
	}
	public void setBhidden(String bhidden) {
		this.bhidden = bhidden;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", bdiv=" + bdiv + ", btitle=" + btitle + ", bwriter=" + bwriter + ", bcont="
				+ bcont + ", bregdt=" + bregdt + ", bupdt=" + bupdt + ", viewcnt=" + viewcnt + ", replycnt=" + replycnt
				+ ", bhidden=" + bhidden + "]";
	}
}
