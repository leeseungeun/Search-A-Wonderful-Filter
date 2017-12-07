package com.SWF.board.dto;

public class MapDTO {

	private int bno;
	private double maplatitude;
	private double maplongtitude;
	private double marklatitude;
	private double marklongtitude;

	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public double getMaplatitude() {
		return maplatitude;
	}
	public void setMaplatitude(double maplatitude) {
		this.maplatitude = maplatitude;
	}
	public double getMaplongtitude() {
		return maplongtitude;
	}
	public void setMaplongtitude(double maplongtitude) {
		this.maplongtitude = maplongtitude;
	}
	public double getMarklatitude() {
		return marklatitude;
	}
	public void setMarklatitude(double marklatitude) {
		this.marklatitude = marklatitude;
	}
	public double getMarklongtitude() {
		return marklongtitude;
	}
	public void setMarklongtitude(double marklongtitude) {
		this.marklongtitude = marklongtitude;
	}
	
	@Override
	public String toString() {
		return "MapDTO [bno=" + bno + ", maplatitude=" + maplatitude + ", maplongtitude=" + maplongtitude
				+ ", marklatitude=" + marklatitude + ", marklongtitude=" + marklongtitude + "]";
	}
	
}
