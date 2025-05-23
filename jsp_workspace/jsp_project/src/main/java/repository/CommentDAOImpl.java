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
		int isOk = sql.insert("CommentMapper.add", cvo);
		if(isOk>0) {sql.commit();}
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
		if(isOk>0) {sql.commit();}
		return isOk;
	}

	@Override
	public int delete(int cno) {
		// TODO Auto-generated method stub
		int isOk = sql.update("CommentMapper.del", cno);
		if(isOk>0) {sql.commit();}
		return isOk;
	}
	
}