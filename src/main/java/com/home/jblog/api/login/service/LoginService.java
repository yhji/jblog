package com.home.jblog.api.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.jblog.api.login.mapper.LoginMapper;
import com.home.jblog.api.login.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginService {
	
	@Autowired
	LoginMapper loginMapper;
	
	public UserVO selectUser(UserVO param){
		log.info("LoginService.login start..");
		
		
		//log.info("LoginService.login end..");
		
		return loginMapper.selectUser(param);
	}
	
}
