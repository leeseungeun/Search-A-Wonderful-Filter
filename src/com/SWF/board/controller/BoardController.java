package com.SWF.board.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SWF.board.dto.BoardDTO;
import com.SWF.board.dto.MapDTO;
import com.SWF.board.dto.Page;
import com.SWF.board.dto.PageHelper;
import com.SWF.board.service.BoardService;
import com.SWF.user.service.UserService;
import com.SWF.utils.FileUploadUtil;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private UserService uService;
	
	@Inject
	private BoardService bService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(@ModelAttribute("page") Page page,Model model) throws Exception{
		
		model.addAttribute("list", bService.list(page));
		
		PageHelper pageHelper = new PageHelper();
		pageHelper.setPage(page);
		pageHelper.setTotalRecord(bService.cout4list(page));
		
		model.addAttribute("pageHelper",pageHelper);
	}
		
	@RequestMapping(value="/writeForm", method=RequestMethod.GET)
	public void writeGet(Model model) throws Exception{
		
		model.addAttribute("sidoList", uService.getSidoList());
		model.addAttribute("bno",bService.getBno());
		
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writePost(BoardDTO bDto, MapDTO mDto, RedirectAttributes rttr) throws Exception{
		
		bService.writeBoard(bDto, mDto);
		
		rttr.addFlashAttribute("msg","성공적으로 등록했습니다.");
		
		return "redirect:/board/list";
	}
	
	@ResponseBody
	@RequestMapping(value="/fileUpload", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public void fileUpload(HttpServletRequest request, HttpServletResponse response,MultipartFile upload) throws Exception{
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String realPath = session.getServletContext().getRealPath("/WEB-INF/SWFServer/attach");
		
		String originalfilenm = upload.getOriginalFilename();
		
		String result = FileUploadUtil.uploadAttFile(realPath, originalfilenm, upload.getBytes());
				
		String callback =request.getParameter("CKEditorFuncNum");
		String fileUrl ="/SWFServer/attach"+result;	
	    
	    PrintWriter printWriter=response.getWriter();
	    
	    StringBuilder script= new StringBuilder();
	    script.append("<script>window.parent.CKEDITOR.tools.callFunction(");
	    script.append(callback);
	    script.append(", '");
	    script.append(fileUrl);
	    script.append(" ' , '이미지를 업로드 했습니다.'");
	    script.append("); </script>");
	    
	    printWriter.println(script);
	    printWriter.flush();
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno,@ModelAttribute("page") Page page, Model model) throws Exception{

		Map<String, Object> result = bService.readBoard(bno);
		BoardDTO bDto = (BoardDTO)result.get("bDto");
		MapDTO mDto = (MapDTO)result.get("mDto");
		
		model.addAttribute("bDto",bDto);
		model.addAttribute("mDto",mDto);

	}
	
	@RequestMapping(value="/modifyForm", method=RequestMethod.GET)
	public void modifyGet(@RequestParam("bno") int bno, @ModelAttribute("page") Page page, Model model) throws Exception{
	
		Map<String, Object> result = bService.readBoard(bno);
		BoardDTO bDto = (BoardDTO)result.get("bDto");
		MapDTO mDto = (MapDTO)result.get("mDto");
		
		model.addAttribute("bDto",bDto);
		model.addAttribute("mDto",mDto);
		
		model.addAttribute("sidoList", uService.getSidoList());
		
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPost(BoardDTO bDto, MapDTO mDto, Page page, RedirectAttributes rttr) throws Exception{
		
		bService.modifyBoard(bDto, mDto);
		
		rttr.addAttribute("curPage",page.getCurPage());
		rttr.addAttribute("recordPerPage", page.getRecordPerPage());
		rttr.addAttribute("searchType",page.getSearchType());
		rttr.addAttribute("searchKeyword",page.getSearchKeyword());
		rttr.addAttribute("bno",bDto.getBno());
		
		rttr.addFlashAttribute("msg","성공적으로 수정하였습니다.");
		
		return "redirect:/board/read";
		
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, @ModelAttribute("page") Page page, RedirectAttributes rttr) throws Exception{
		
		bService.removeBoard(bno);
		
		rttr.addAttribute("curPage",page.getCurPage());
		rttr.addAttribute("recordPerPage", page.getRecordPerPage());
		rttr.addAttribute("searchType",page.getSearchType());
		rttr.addAttribute("searchKeyword",page.getSearchKeyword());
		
		rttr.addFlashAttribute("msg", "성공적으로 삭제했습니다.");
		
		return "redirect:/board/list";
	}
		
}
