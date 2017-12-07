package com.SWF.board.dto;

import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageHelper {
	
	private int totalRecord;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private Page page;

	private int displayPageNum = 5;
	
	private void calcPage(){
		
		endPage = (int)(Math.ceil(page.getCurPage()/(double)displayPageNum)*displayPageNum);
		startPage = (endPage-displayPageNum)+1;
		
		int tmpEndPage = (int)(Math.ceil(totalRecord/(double)page.getRecordPerPage()));
		
		if(endPage > tmpEndPage){
			endPage = tmpEndPage;
		}
		
		prev = startPage==1? false:true;
		next = endPage * page.getRecordPerPage() >= totalRecord? false:true;
	}
	
	private String encoding(String searchKeyword){
		
		if(searchKeyword==null||searchKeyword.trim().length()==0){
			return "";
		}
		
		try {
			return URLEncoder.encode(searchKeyword,"UTF-8");
		} catch (Exception e) {
			return "";						
		}
		
	}
	
	public String makeQuery(int curPage){
		
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance()
				.queryParam("curPage", curPage)
				.queryParam("recordPerPage", page.getRecordPerPage())
				.build();
		
		return uriComponents.toUriString();
		
	}
	
	public String makeQueryWithSearch(int curPage){
		
		UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
				.queryParam("curPage", curPage)
				.queryParam("recordPerPage", page.getRecordPerPage())
				.queryParam("searchType", page.getSearchType())
				.queryParam("searchKeyword", encoding(page.getSearchKeyword()))
				.build();
		
		return uriComponents.toUriString();
	}
	
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		
		calcPage();
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "PageHelper [totalRecord=" + totalRecord + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", prev=" + prev + ", next=" + next + ", page=" + page + ", displayPageNum=" + displayPageNum + "]";
	}
	
}
