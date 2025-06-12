package com.koreait.www.repository;

import java.util.List;

import com.koreait.www.domain.AuthVO;
import com.koreait.www.domain.UserVO;

public interface UserDAO {

	int insert(UserVO uvo);

	int insertUathInit(String email);

	UserVO getUser(String username);

	List<AuthVO> getAuthList(String username);

	int updateLastLogin(String authEmail);

	int modifyPwdEmpty(UserVO uvo);

	int modify(UserVO uvo);

	List<UserVO> getList();

	int removeAuth(String email);

	int remove(String email);

}