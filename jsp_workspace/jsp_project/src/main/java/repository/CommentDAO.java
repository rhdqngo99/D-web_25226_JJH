package repository;

import java.util.List;

import domain.CommentVO;

public interface CommentDAO {

	int post(CommentVO cvo);

	List<CommentVO> getList(int bno);

	int modify(CommentVO cvo);

	int delete(int cno);

	int commentDaleteAll(int bno);

}
