package com.koreait.www.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koreait.www.domain.BoardDTO;
import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.FileVO;
import com.koreait.www.domain.PagingVO;
import com.koreait.www.repository.BoardDAO;
import com.koreait.www.repository.FileDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardSeviceImpl implements BoardService {
	
	private final BoardDAO bdao;
	private final FileDAO fdao;

	@Transactional
	@Override
	public int insert(BoardDTO bdto) {
		// BoardDTO => BoardVO + flist
		int isOk = bdao.insert(bdto.getBvo()); // bvo가 등록되어봐야 아는 번호
		if(bdto.getFlist() == null) {
			return isOk;
		}
		// fileDAO 생성 => fileMapper 를 생성하여 fvo 값을 DB로 등록
		// fileVO.setBno 
		if(isOk > 0) {
			long bno = bdao.getBno();
			for(FileVO fvo : bdto.getFlist()) {
				fvo.setBno(bno);
				// 저장
				isOk *= fdao.insertFile(fvo);
			}
			isOk *= bdao.fileQtyUpdate(bno, bdto.getFlist().size());
		}
		
		return isOk;
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.getList(pgvo);
	}

	@Transactional
	@Override
	public BoardDTO getDetail(long bno) {
		// TODO Auto-generated method stub
		BoardVO bvo = bdao.getDetail(bno);
		List<FileVO> flist = fdao.getList(bno);
		BoardDTO bdto = new BoardDTO(bvo, flist);
		return bdto;
	}

//	@Override
//	public BoardVO getDetail(long bno) {
//		// TODO Auto-generated method stub
//		return bdao.getDetail(bno);
//	}

	@Transactional
	@Override
	public int update(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		int isOk = bdao.readCountUp(boardDTO.getBvo().getBno(), -1);
		if(isOk > 0) {
			isOk *= bdao.update(boardDTO.getBvo());
		}
		if(boardDTO.getFlist() == null) {
			return isOk;
		}
		if(isOk>0) {
			for(FileVO fvo : boardDTO.getFlist()) {
				fvo.setBno(boardDTO.getBvo().getBno());
				isOk *= fdao.insertFile(fvo);
			}
			isOk *= bdao.fileQtyUpdate(boardDTO.getBvo().getBno(), boardDTO.getFlist().size());
		}
		return isOk; 
	}

	@Override
	public int delete(long bno) {
		// TODO Auto-generated method stub
		return bdao.delete(bno);
	}

	@Override
	public int readCountUp(long bno, int i) {
		// TODO Auto-generated method stub
		return bdao.readCountUp(bno, i);
	}

	@Override
	public int getTotalCount(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.getTotalCount(pgvo);
	}

	@Transactional
	@Override
	public int removeFile(String uuid) {
		// TODO Auto-generated method stub
		long bno = fdao.getBno(uuid);
		int isOk = fdao.removeFile(uuid);
		if(isOk >0) {
			isOk *= bdao.fileQtyUpdate(bno, -1);
		}
		return isOk; 
	}

	@Override
	public FileVO getFile(String uuid) {
		// TODO Auto-generated method stub
		return fdao.getFile(uuid);
	}

}