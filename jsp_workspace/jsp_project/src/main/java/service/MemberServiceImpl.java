package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	// DAO interface
	private MemberDAO mdao;
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();  // interface 구현체
	}

	@Override
	public int insert(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mdao.insert(mvo);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mdao.login(mvo);
	}

	@Override
	public int lastloginUpdate(String id) {
		// TODO Auto-generated method stub
		return mdao.lastloginUpdate(id);
	}

	@Override
	public List<MemberVO> getList() {
		// TODO Auto-generated method stub
		return mdao.getList();
	}

	@Override
	public int update(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mdao.update(mvo);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return mdao.delete(id);
	}

}
