package com.home.jblog.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest req
							,HttpServletResponse res
							,Object handler) {
		log.info("WebInterceptor.preHandle...");
		
		//String contextPath = req.getContextPath();
		String requestUri = req.getRequestURI();
		String method = req.getMethod();
		String queryParam = req.getQueryString();
		
		//log.info("WebInterceptor.preHandle... contextPath=" + contextPath);
		log.info("WebInterceptor.preHandle... requestUri=" + requestUri);
		log.info("WebInterceptor.preHandle... method=" + method);
		log.info("WebInterceptor.preHandle... queryParam=" + queryParam);
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request
							,HttpServletResponse response
							,Object handler
							,ModelAndView modelAndView) {
		log.info("WebInterceptor.postHandle...");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request
								,HttpServletResponse response
								,Object handler
								,Exception ex) {
		log.info("WebInterceptor.afterCompletion...");
	}
	
	
	
}
