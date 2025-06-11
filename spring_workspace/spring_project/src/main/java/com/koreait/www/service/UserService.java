package com.koreait.www.service;

import java.util.List;

import com.koreait.www.domain.UserVO;


public interface UserService {
	
	int insert(UserVO uvo);

	int modifyPwdEmpty(UserVO uvo);

	int modify(UserVO uvo);

	List<UserVO> getList();

	int delete(String email);

}
