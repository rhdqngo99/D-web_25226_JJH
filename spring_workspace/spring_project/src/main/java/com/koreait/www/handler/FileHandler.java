package com.koreait.www.handler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.tika.Tika;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.www.domain.FileVO;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Slf4j
@Component // 사용자 클래스를 빈으로 등록하는 어노테이션
public class FileHandler {
	
	// 저장경로
	private final String UP_DIR = "D:\\web_25226_JJH\\_myproject\\_java\\_fileUpload";
	
	// Multipartfile[] 파라미터로 받고, List<FileVO> 로 리턴 (+ 저장)
	public List<FileVO> uploadFile(MultipartFile[] files){
		
		List<FileVO> flist = new ArrayList<FileVO>();
		
		// fileVO 생성 + 파일 저장 + 그림파일일 경우 썸네일 저장
		// 일반적으로 파일을 저장시 날짜별로 폴더화 하여 업로드된 파일 관리
		LocalDate date = LocalDate.now(); // 오늘날짜 리턴 2025-06-05
		log.info(">>>> date >>{}", date);
		String today = date.toString();
		today = today.replace("-", File.separator); //  2025/06/05 win(\), mac(/)
		
		//D:\\web_25226_JJH\\_myproject\\_java\\_fileUpload\\2025\\06\\05
		File folders = new File(UP_DIR, today);
		// mkdir : 폴더 생성 명령어(1개만 생성) / mkdirs (하위폴더까지 생성)
		if(!folders.exists()) {  //폴더가 없다면
			folders.mkdirs();
		}
		
		// files 를 가지고 fileVO 생성
		for(MultipartFile file : files) {
			FileVO fvo = new FileVO();
			//uuid, saveDir, fileName, fileType, fileSize
			fvo.setSaveDir(today); // 2025\\06\\05
			fvo.setFileSize(file.getSize());
			log.info(">>> getName >> {}",file.getName()); // files
			log.info(">>> getOriginalFilename >> {}",file.getOriginalFilename()); // naver.png
			String fileName = file.getOriginalFilename();
			fvo.setFileName(fileName);
			
			UUID uuid = UUID.randomUUID();
			String uuidStr = uuid.toString();
			fvo.setUuid(uuidStr);
			
			//----- fvo 생성 완료  // fileType / bno
			// 디스크에 저장
			String fullFileName = uuidStr+"_"+fileName;
			File storeFile = new File(folders, fullFileName);
			
			// 저장
			try {
				file.transferTo(storeFile); // 저장
				// 썸네일 저장 (이미지만 가능)
				// 이미지인지 확인 => tika
				if(isImageFile(storeFile)) {
					fvo.setFileType(1);
					//썸네일 생성
					File thumbNail = new File(folders, uuidStr+"_th_"+fileName);
					Thumbnails.of(storeFile).size(100, 100).toFile(thumbNail);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				log.info("file store error");
				e.printStackTrace();
			}
			// for문 끝나기 전에 list에 추가
			flist.add(fvo);	
		}
		
		return flist;
	}
	
	private boolean isImageFile(File storeFile) throws IOException {
		// type "image/png"
		String mimeType = new Tika().detect(storeFile);
		return mimeType.startsWith("image") ? true : false;
	}
	
}
