package com.SWF.search.dto;

import cc.mallet.types.Label;

public class SearchDTO {
	
	private String url;
	private String title;
	private Label label;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return "SearchDTO [url=" + url + ", title=" + title + ", label=" + label
				+ "]";
	}
	
}
