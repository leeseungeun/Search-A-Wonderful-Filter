package com.SWF.search.analyze;

import java.util.List;

import com.SWF.search.dto.SearchDTO;
import com.SWF.utils.FileSave;

public class PrepareDataSet {

	public void  saveDataWithDom(String dom, String location) throws Exception{
		
		String text = new ParseDOM().getParsedElement(dom, ".se_textarea");
		if(text==null || text.length()==0){
			text = new ParseDOM().getParsedElement(dom, "#postViewArea p span");
		}
		if(text==null || text.length()==0){
			text = new ParseDOM().getParsedElement(dom, ".view p");
		}
		if(text==null || text.length()==0){
			text = new ParseDOM().getParsedElement(dom, ".view div");
		}
		if(text==null || text.length()==0){
			text = new ParseDOM().getParsedElement(dom, "#postViewArea div div");
		}
		if(text==null || text.length()==0){
			text = new ParseDOM().getParsedElement(dom, "#postViewArea p");
		}
		if(text==null || text.length()==0){
			text = new ParseDOM().getParsedElement(dom, "#postViewArea div");
		}
		text = new AnalyzeMorph().analyze(text);
		new FileSave().saveAsFile(location, text);
		
	}
	
	public void saveData(String url, String location) throws Exception{
		
		String dom = new GetDOM().dom2String(url);

		saveDataWithDom(dom, location);
		
	}
	
	public void saveData(SearchDTO sDto, String location) throws Exception {

		String url = sDto.getUrl();

		saveData(url, location);

	}

	public void saveData(List<SearchDTO> list, String location) throws Exception{

		for(int i=0;i<list.size();i++){

			String fullpath = "";
			
			fullpath = location+i+".txt";
			
			SearchDTO sDto = list.get(i);

			saveData(sDto, fullpath);

		}
	}
}
