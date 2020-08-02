package com.home.jblog.api.login.vo;

import lombok.Data;

@Data
public class UserVO {
	
	String userId;
	String userPw;
	String userNm;
	String phoneNum;
	String addr;
	String tokenVal;
	
}
