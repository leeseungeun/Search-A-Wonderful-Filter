package com.SWF.user.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SWF.user.dto.UserDTO;
import com.SWF.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Inject
	private UserService uService;
	
	@RequestMapping(value="/joinForm", method=RequestMethod.GET)
	public void joinGet(Model model) throws Exception{
		
		model.addAttribute("sidoList", uService.getSidoList());
		model.addAttribute("bno",1);
	}
	
	@ResponseBody
	@RequestMapping(value="/emailValidation", method=RequestMethod.POST)
	public String emailValidation(@RequestBody String email) throws Exception{
		
		return uService.sendValidationMail(email);
	
	}
	
	@ResponseBody
	@RequestMapping(value="/getGugun", method=RequestMethod.GET)
	public List<String> getGugun(String sido) throws Exception{

		return uService.getGugunList(sido);
	
	}
	
	@ResponseBody
	@RequestMapping(value="/getDong", method=RequestMethod.GET)
	public List<String> getDong(String gugun) throws Exception{
		
		return uService.getDongList(gugun);
		
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPost(UserDTO uDto, RedirectAttributes rttr) throws Exception{
		
		uService.join(uDto);
		
		rttr.addFlashAttribute("msg","성공적으로 가입하셨습니다.");
		
		return "redirect:/user/loginForm";
	}
	
	@RequestMapping(value="findPWForm", method=RequestMethod.GET)
	public void findPWGet() throws Exception{
	}
	
	@RequestMapping(value="findPW", method=RequestMethod.POST)
	public String findPWPost(String email, String umsg, RedirectAttributes rttr) throws Exception{
		
		int result = uService.findPW(email, umsg);
		
		if(result==-1){
			rttr.addFlashAttribute("msg","존재하지 않는 사용자입니다.");
		} else if(result==0){
			rttr.addFlashAttribute("msg","본인 확인 메시지가 일치하지 않습니다.");
		} else if(result==1){
			rttr.addFlashAttribute("msg","임시 비밀번호가 발송되었습니다.");
		}
		
		return "redirect:/user/loginForm";
	}
	
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public void loginGet(@ModelAttribute("uDto") UserDTO uDto) throws Exception{
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPost(String email, String upw, boolean useCookie, HttpSession session, Model model) throws Exception{
		
		UserDTO uDto = uService.login(email, upw);
	
		if(uDto==null){
			model.addAttribute("msg","이메일 혹은 비밀번호를 확인해주세요.");
			return "/user/loginForm";
		}
		
		model.addAttribute("uDto",uDto);
		
		if(useCookie){
			
			int expiration = 60 * 60 * 24 * 7;
			Date sessionlimit = new Date(System.currentTimeMillis()+(1000*expiration));
			
			String sessionid = session.getId();
			
			uService.saveLoginStatus(email, sessionid, sessionlimit);
		}
		
		return "/user/login";		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request
			, HttpServletResponse response
			, HttpSession session) throws Exception{
		
		Object obj = session.getAttribute("login");
		
		if(obj != null){
			
			session.removeAttribute("login");
			session.invalidate();
			
		}
		return "/search/search";
	}
	
	@RequestMapping(value="/myPageForm", method=RequestMethod.GET)
	public void myPageGet(HttpSession session, Model model) throws Exception{
		
		UserDTO uDto = (UserDTO)session.getAttribute("login");
		
		model.addAttribute(uService.getMyPage(uDto.getEmail()));
		model.addAttribute("sidoList", uService.getSidoList());
		
	}
	
	@RequestMapping(value="/myPage", method=RequestMethod.POST)
	public String myPagePost(UserDTO uDto
						   , String modifyConfirm
						   , Boolean isPwChange
						   , RedirectAttributes rttr) throws Exception{
		
		
		int result = uService.modifyMyInfo(uDto, modifyConfirm, isPwChange);
		
		if(result != 1){
			rttr.addFlashAttribute("msg","비밀번호를 다시 확인해주세요.");
		} else{
			rttr.addFlashAttribute("msg","성공적으로 수정되었습니다.");
		}
		
		
		return "redirect:/user/myPageForm";
	}
}
