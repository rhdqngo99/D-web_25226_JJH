package com.koreait.www.repository;

import java.util.List;

import com.koreait.www.domain.FileVO;

public interface FileDAO {

	int insertFile(FileVO fvo);

	List<FileVO> getList(long bno);

	int removeFile(String uuid);

	FileVO getFile(String uuid);

	List<FileVO> getAllFileList();

	long getBno(String uuid);

}

