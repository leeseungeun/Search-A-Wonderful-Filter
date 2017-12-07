package com.SWF.search.service;

import com.SWF.search.dto.ResultDTO;

public interface SearchService {

	public ResultDTO getSearchReuslt(int page, String keyword,String email) throws Exception;
	
}
