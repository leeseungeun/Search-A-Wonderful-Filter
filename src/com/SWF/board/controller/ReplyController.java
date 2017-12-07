package com.SWF.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SWF.board.dto.Page;
import com.SWF.board.dto.PageHelper;
import com.SWF.board.dto.ReplyDTO;
import com.SWF.board.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {

	@Inject
	private ReplyService rService;
	
	@RequestMapping(value="/{bno}/{curPage}", method=RequestMethod.GET)
	public Map<String,Object> list(@PathVariable("bno") Integer bno, @PathVariable("curPage") Integer curPage) throws Exception{
		
		Page page = new Page();
		page.setCurPage(curPage);
		
		PageHelper pageHelper = new PageHelper();
		pageHelper.setPage(page);
		
		Map<String, Object> map = new HashMap<String,Object>();
				
		List<ReplyDTO> list = rService.list(bno,page);
		map.put("list", list);
		
		int replyCnt = rService.replyCnt(bno);
		
		pageHelper.setTotalRecord(replyCnt);
		map.put("pageHelper", pageHelper);
		
		return map;
	}
	
	@RequestMapping(value="/{bno}", method=RequestMethod.POST)
	public String write(@PathVariable("bno") Integer bno, @RequestBody ReplyDTO rDto) throws Exception{
		
		rService.writeReply(bno, rDto);
		
		
		return "1";
	}
	
	@RequestMapping(value="/{bno}/{rno}",method=RequestMethod.DELETE)
	public String remove(@PathVariable("bno") Integer bno, @PathVariable("rno") Integer rno) throws Exception{
		
		rService.removeReply(bno, rno);
		
		return "1";
	}
}
