package com.koreait.www.handler;

import java.io.File;

import com.koreait.www.domain.FileVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileRemoveHandler {
	
	// 저장경로
	private final String DIR = "D:\\web_25226_JJH\\_myproject\\_java\\_fileUpload";
	
	public int removeFile(FileVO fvo) {
		//D:\\web_25226_JJH\\_myproject\\_java\\_fileUpload\\2025\\06\\05\\uuid_fileName
		//D:\\web_25226_JJH\\_myproject\\_java\\_fileUpload\\2025\\06\\05\\uuid_th_fileName
		// file.delete()  // 파일 삭제
		// image file (=> file_type) 같이 삭제 / 아니면 파일만 삭제
		boolean isDel = false;
		
		File fileDir = new File(DIR, fvo.getSaveDir());
		String removeFile = fvo.getUuid()+"_"+fvo.getFileName();
		File deleteFile = new File(fileDir, removeFile);
		String removeThFile = fvo.getUuid()+"_th_"+fvo.getFileName();
		File deleteThFile = new File(fileDir, removeThFile);
		
		try {
			// 파일이 존재하는지 확인
			if(deleteFile.exists()) {
				isDel = deleteFile.delete();
				log.info(">>>> delete File Success >> {}", deleteFile.toString());
				if(fvo.getFileType() == 1 && deleteThFile.exists()) {
					isDel = deleteThFile.delete();
					log.info(">>>> delete Thumb File Success >> {}", deleteThFile.toString());
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info(">>>> delete File Error");
			e.printStackTrace();
		}
		
		return isDel? 1:0;
	}

}