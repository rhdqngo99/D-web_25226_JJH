package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import orm.DatabasesBulder;

public class CommentDAOImpl implements CommentDAO {
	
	private static final Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);
	
	private SqlSession sql;
	
	public CommentDAOImpl() {
		new DatabasesBulder();
		sql = DatabasesBulder.getFactory().openSession();
	}

	@Override
	public int post(CommentVO cvo) {
		// TODO Auto-generated method stub
		int isOk = sql.insert("CommentMapper.add", cvo);
		if(isOk>0) { sql.commit();}
		return isOk;
	}

	@Override
	public List<CommentVO> getList(int bno) {
		// TODO Auto-generated method stub
		return sql.selectList("CommentMapper.list", bno);
	}

	@Override
	public int modify(CommentVO cvo) {
		// TODO Auto-generated method stub
		int isOk = sql.update("CommentMapper.up", cvo);
		if(isOk>0) { sql.commit();}
		return isOk;
	}

	@Override
	public int delete(int cno) {
		// TODO Auto-generated method stub
		int isOk = sql.delete("CommentMapper.del", cno);
		if(isOk>0) {sql.commit();}
		return isOk;
	}

	@Override
	public int commentDeleteAll(int bno) {
		// 댓글이 있는지 여부를 확인
		int isOk = 1;
		int commentCount = sql.selectOne("CommentMapper.cmtCount", bno);
		// 댓글이 있다면 삭제 
		if(commentCount > 0) {
			isOk *= sql.delete("CommentMapper.cmtDeleteAll", bno);
		}
		if(isOk > 0) {sql.commit();}
				
		return isOk;
	}

}
