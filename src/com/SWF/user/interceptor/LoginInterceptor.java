package com.SWF.user.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.SWF.user.dto.UserDTO;
import com.SWF.user.service.UserService;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Inject
	UserService uService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("login") != null){
			
			session.removeAttribute("login");
		
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		UserDTO uDto = (UserDTO) modelMap.get("uDto");
		if(uDto != null){

			session.setAttribute("login", uDto);
			uService.Attendence(uDto.getEmail());
			
			if(request.getParameter("useCookie") != null){
					
				Cookie loginCookie = new Cookie("loginCookie",session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60*60*24*7);
				response.addCookie(loginCookie);
					
			}
					
			Object dest = session.getAttribute("dest");
			response.sendRedirect(dest != null? (String)dest:"/");
		}
		
	}
}
