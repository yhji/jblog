package com.home.jblog.api.login.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginService {
	
	public Map<String, Object> login(Map<String, Object> param){
		log.info("LoginService.login start..");
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		
		
		log.info("LoginService.login end..");
		
		return resultMap;
	}
	
}
