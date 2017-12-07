package com.SWF.search.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SWF.search.service.SearchService;
import com.SWF.user.dto.UserDTO;

@Controller
public class SearchController {
	
	@Inject
	private SearchService sService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String search(){
		
		return "search/search";
	
	}
	
	@RequestMapping(value="/search/result", method=RequestMethod.GET)
	public String searchResult(int page, String keyword, Model model,HttpSession session) throws Exception{

		UserDTO uDto = (UserDTO)session.getAttribute("login");
		String email = uDto.getEmail();
		
		model.addAttribute("rDto",sService.getSearchReuslt(page, keyword,email));
		model.addAttribute("page",page);
		model.addAttribute("keyword",keyword);
		
		return "search/result";
	}
}
