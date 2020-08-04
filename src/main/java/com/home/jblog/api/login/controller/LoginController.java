package com.home.jblog.api.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.jblog.api.login.service.LoginService;
import com.home.jblog.api.login.vo.UserVO;
import com.home.jblog.message.CustomMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
//@RequestMapping(value = "")
public class LoginController {
	
	@Autowired
	LoginService service;
	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public CustomMessage test(@RequestBody UserVO vo
//							, CustomMessage message) {
//		log.info("LoginController.test start..");
//		
//		String userId = vo.getUserId();
//		log.info("LoginController.test userId :: " + userId);
//		
//		log.info("LoginController.test end..");
//		
//		message.setData(vo);
//		return message;
//	}
	
	
	@RequestMapping(value = "/procLogin", method = RequestMethod.POST)
	public CustomMessage login(@RequestBody UserVO param
							, HttpServletRequest request
							, HttpServletResponse response
							, CustomMessage message) {
		log.info("LoginController.login start..");
		
		
		String userId = param.getUserId();
		String userPw = param.getUserPw();
		log.info("LoginController.test userId :: " + userId);
		log.info("LoginController.test userPw :: " + userPw);
		
		UserVO vo = service.selectUser(param);
		message.setData(vo);
		
		log.info("LoginController.login end..");
		
		return message;
	}
	
}
