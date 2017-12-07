package com.SWF.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception ex){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error/error");
		/*modelAndView.addObject("exception",ex);*/
		
		return modelAndView;
	
	}
	
}
