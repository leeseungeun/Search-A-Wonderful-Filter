package com.SWF.search.analyze;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseDOM {
	
	public List<String> getParsedElement(String DOM, String tag, String attr) throws Exception{
		
		List<String> resultList = new ArrayList<String>();
		
		Document doc = Jsoup.parse(DOM);
		
		Elements elements = doc.select(tag);
		
		for (Element element : elements) {
			
			String strElement = element.attr(attr);
			resultList.add(strElement);
			
		}
		
		return resultList;
	}

	public List<String> getParsedTitle(String DOM, String tag) throws Exception{
		
		List<String> resultList = new ArrayList<String>();
		
		Document doc = Jsoup.parse(DOM);
		
		Elements elements = doc.select(tag);
		
		for (Element element : elements) {
			
			String strElement = element.text();
			resultList.add(strElement);
			
		}
		
		return resultList;
	}
	
	public String getParsedElement(String DOM, String tag) throws Exception{
		
		StringBuilder sb = new StringBuilder();
		
		Document doc = Jsoup.parse(DOM);
		
		Elements elements = doc.select(tag);
		
		for (Element element : elements) {
			
			String strElement = element.text();
			sb.append(strElement);
			
		}
		
		return sb.toString();
	}
	
}
