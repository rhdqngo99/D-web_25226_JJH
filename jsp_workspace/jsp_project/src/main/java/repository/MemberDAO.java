package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	MemberVO login(MemberVO mvo);

	int lastloginUpdate(String id);

	List<MemberVO> getList();

	int update(MemberVO mvo);

	int delete(String id);

}