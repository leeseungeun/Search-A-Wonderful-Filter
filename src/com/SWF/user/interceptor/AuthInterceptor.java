package com.SWF.user.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.SWF.user.dto.UserDTO;
import com.SWF.user.service.UserService;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	@Inject
	private UserService uService;
	
	private void destRecord(HttpServletRequest req){
		
		String uri = req.getRequestURI();
		String query = req.getQueryString();
		
		if(query==null || query.equals("null")){
			query = "";
		} else{
			query = "?"+query;
		}
		
		if(req.getMethod().equals("GET")){
			req.getSession().setAttribute("dest", uri+query);
		}
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login")==null){
			
			destRecord(request);
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			if(loginCookie != null){
				
				UserDTO uDto = uService.checkLoginStatus(loginCookie.getValue());
				
				if(uDto != null){
					session.setAttribute("login", uDto);
					uService.Attendence(uDto.getEmail());
					
					return true;
				}
			}
			
			response.sendRedirect("/user/loginForm");
			return false;
		
		}
		return true;
	}
	
}
