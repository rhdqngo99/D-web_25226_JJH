package com.koreait.www.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koreait.www.domain.UserVO;
import com.koreait.www.repository.UserDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServicelmpl implements UserService {
	
	private final UserDAO udao;

	@Transactional
	@Override
	public int insert(UserVO uvo) {
		// TODO Auto-generated method stub
		int isOk = udao.insert(uvo); 
		return udao.insertUathInit(uvo.getEmail());
	}

	@Override
	public int modifyPwdEmpty(UserVO uvo) {
		// TODO Auto-generated method stub
		return udao.modifyPwdEmpty(uvo);
	}

	@Override
	public int modify(UserVO uvo) {
		// TODO Auto-generated method stub
		return udao.modify(uvo);
	}

	@Transactional
	@Override
	public List<UserVO> getList() {
		// userVO 와 authList 두개의 값을 가져와야 함.
		List<UserVO> userList = udao.getList();
		for(UserVO uvo : userList) {
			uvo.setAuthList(udao.getAuthList(uvo.getEmail()));
		}
		return userList;
	}

	@Transactional
	@Override
	public int delete(String email) {
		// TODO Auto-generated method stub
		int isOk = udao.removeAuth(email);
		return udao.remove(email);
	}

}