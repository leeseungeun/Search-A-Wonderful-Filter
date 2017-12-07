package com.SWF.search.analyze;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.SWF.search.dto.SearchDTO;

public class GetUrlList {

	public List<SearchDTO> getUrlListMan(String[] rawUrls) throws Exception{
		List<SearchDTO> urls = new ArrayList<SearchDTO>();
		
		for(int i=0;i<rawUrls.length;i++){
			
			SearchDTO sDto = new SearchDTO();
			
			String rawUrl = rawUrls[i];
			String id = null;
			String logNo= null;
			
			StringBuilder url = new StringBuilder("http://blog.naver.com/PostView.nhn?blogId=");
			
			if(!rawUrl.contains("blog.me")){
				id =rawUrl.substring(22,rawUrl.lastIndexOf('/'));
				logNo=rawUrl.substring(rawUrl.lastIndexOf('/')+1);
			}else{
				id=rawUrl.substring(7,rawUrl.indexOf('.'));
				logNo=rawUrl.substring(rawUrl.lastIndexOf('/')+1);
			}
			
			url.append(id);
			url.append("&logNo=");
			url.append(logNo);
			url.append("&redirect=Dlog&widgetTypeCall=true");

			sDto.setUrl(url.toString());

			urls.add(sDto);
		
		}
		
		return urls;
	}
	
	public List<SearchDTO> getUrlList(int page, String keyword) throws Exception{

		List<SearchDTO> urls = new ArrayList<SearchDTO>();

		for(int i=1;i<=page;i++){
			
			urls.addAll(getUrlListPerPage(i,keyword));
			
		}

		return urls;
	}
		
	public List<SearchDTO> getUrlListPerPage(int page, String keyword) throws Exception{
		
		List<SearchDTO> urls = new ArrayList<SearchDTO>();
		
		keyword = URLEncoder.encode(keyword,"UTF-8");
		
		StringBuilder sb = new StringBuilder("https://section.blog.naver.com/sub/SearchBlog.nhn?type=post&term=&option.startDate=&option.endDate=&option.orderBy=sim&option.keyword=");
		sb.append(keyword);
		sb.append("%EB%A7%9B%EC%A7%91&option.page.currentPage=");
		sb.append(page);

		String dom = new GetDOM().dom2String(sb.toString());
		
		List<String> ids = new ParseDOM().getParsedElement(dom, ".vBlogId", "value");
		List<String> logNos = new ParseDOM().getParsedElement(dom, ".vLogNo", "value");
		List<String> title = new ParseDOM().getParsedTitle(dom, "li h5 a");
		
		for(int i=0;i<ids.size();i++){

			SearchDTO sDto = new SearchDTO();

			StringBuilder url = new StringBuilder("http://blog.naver.com/PostView.nhn?blogId=");
			
			url.append(ids.get(i));
			url.append("&logNo=");
			url.append(logNos.get(i));
			url.append("&redirect=Dlog&widgetTypeCall=true");

			sDto.setUrl(url.toString());
			sDto.setTitle(title.get(i));
			
			urls.add(sDto);
		}
		
		return urls;
	}
	
}
