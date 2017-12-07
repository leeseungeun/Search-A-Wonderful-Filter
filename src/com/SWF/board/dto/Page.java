package com.SWF.board.dto;

public class Page {
	
	private int curPage;
	private int recordPerPage;
	private String searchType;
	private String searchKeyword;
	
	public Page(){
		this.curPage = 1;
		this.recordPerPage = 10;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		
		if(curPage <= 0){
			this.curPage = 1;
			return;
		}
		
		this.curPage = curPage;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		
		if(recordPerPage <= 0 || recordPerPage > 50){
			this.recordPerPage = 10;
			return;
		}
		
		this.recordPerPage = recordPerPage;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	public int getFirstRecord() {
		return (this.curPage-1)*recordPerPage;
	}

	@Override
	public String toString() {
		return "Page [curPage=" + curPage + ", recordPerPage=" + recordPerPage 
				+ ", searchType=" + searchType + ", searchKeyword=" + searchKeyword + "]";
	}
	
}
