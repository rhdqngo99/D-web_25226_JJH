package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabasesBulder;

public class MemberDAOImpl implements MemberDAO{
	
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	//sqlSession 객체 생성
	private SqlSession sql;
	
	public MemberDAOImpl() {
		new DatabasesBulder();
		sql = DatabasesBulder.getFactory().openSession();
	}

	// namespace = MemberMapper  => MemberMapper.id
	@Override
	public int insert(MemberVO mvo) {
		// TODO Auto-generated method stub
		int isOk = sql.insert("MemberMapper.add", mvo);
		if(isOk >0) {sql.commit();}
		return isOk;
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		// TODO Auto-generated method stub
		return sql.selectOne("MemberMapper.login", mvo);
	}

	@Override
	public int lastloginUpdate(String id) {
		// TODO Auto-generated method stub
		int isOk = sql.update("MemberMapper.last", id);
		if(isOk >0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<MemberVO> getList() {
		// TODO Auto-generated method stub
		return sql.selectList("MemberMapper.list");
	}

	@Override
	public int update(MemberVO mvo) {
		// TODO Auto-generated method stub
		int isOk = sql.update("MemberMapper.up", mvo); 
		if(isOk>0) {sql.commit();}
		return isOk;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		int isOk = sql.delete("MemberMapper.del", id);
		if(isOk>0) {sql.commit();}
		return isOk;
	}
	
}
