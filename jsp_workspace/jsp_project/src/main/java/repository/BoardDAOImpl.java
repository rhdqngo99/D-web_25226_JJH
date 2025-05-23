package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import orm.DatabasesBulder;

public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	//mybatis lib 에서는 SqlSession 
	private SqlSession sql;
	
	public BoardDAOImpl() {
		new DatabasesBulder();
		sql = DatabasesBulder.getFactory().openSession();
	}

	//	메서드 구현
	@Override
	public int insert(BoardVO bvo) {
		// sql.메서드(namespace.id, object);
		log.info("board dao in !!");
		// DB 저장
		int isOk = sql.insert("BoardMapper.add", bvo);
		// insert, update, delete 처럼 DB 값 자체가 변경되는 구문은 
		// 반드시 commit을 해주어야 반영이 됨.
		if(isOk > 0) { sql.commit(); }
		return isOk;
	}

	@Override
	public List<BoardVO> getList() {
		// 전체 리스트를 가져오기
		return sql.selectList("BoardMapper.list");
	}

	@Override
	public BoardVO getDetail(int bno) {
		// TODO Auto-generated method stub
		return sql.selectOne("BoardMapper.detail", bno);
	}

	@Override
	public int update(BoardVO bvo) {
		// TODO Auto-generated method stub
		int isOk = sql.update("BoardMapper.up", bvo);
		if(isOk > 0) { sql.commit(); }
		return isOk;
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		int isOk = sql.delete("BoardMapper.del", bno);
		if(isOk > 0) { sql.commit(); }
		return isOk;
	}
}
