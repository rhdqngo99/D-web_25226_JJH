package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;
import repository.CommentDAO;
import repository.CommentDAOImpl;

public class BoardServiceImpl implements BoardService {
	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	// BoardDAO 인터페이스 생성
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl(); // BoardDAO 구현 클래스
	}

	@Override
	public int insert(BoardVO bvo) {
		// TODO Auto-generated method stub
		log.info(">> board service in  bvo> {}", bvo);
		return bdao.insert(bvo);
	}

//	@Override
//	public List<BoardVO> getList() {
//		// TODO Auto-generated method stub
//		return bdao.getList();
//	}

	@Override
	public BoardVO getDetail(int bno) {
		// TODO Auto-generated method stub
		return bdao.getDetail(bno);
	}

	@Override
	public int update(BoardVO bvo) {
		// TODO Auto-generated method stub
		return bdao.update(bvo);
	}

	@Override
	public int detele(int bno) {
		// 댓글을 먼저 지우고, 파일을 삭제
		CommentDAO cdao = new CommentDAOImpl();
		int isOk = cdao.commentDeleteAll(bno);
		return bdao.delete(bno);
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.getList(pgvo);
	}

	@Override
	public int getTotal(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.getTotal(pgvo);
	}
	
}
