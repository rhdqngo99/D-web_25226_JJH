package com.koreait.www.handler;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.koreait.www.domain.FileVO;
import com.koreait.www.repository.FileDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@EnableScheduling
@RequiredArgsConstructor
@Slf4j
@Component
public class FileSweeper {
	
//	매일 등록된 시간에 파일 정리 => 스케줄러가 실행
// 	화면상에서(DB에서) 삭제되었지만, 실제 파일로 남아있는 파일을 제거
//	FileRemoveHandler를 사용해도 됨. 
//	스케줄 기록 cron 방식 : 초 분 시 일 월 요일 년도(생략가능)
//	cron="59 59 23 * * *" : 매일 23시59분59초에 실행
	
//	DB에 존재하지 않는 파일이 폴더에 존재한다면 삭제
	
	//직접 DB에 접속해서 파일 리스트를 가져와서 폴더의 파일과 비교
	private final FileDAO fdao;
	// 파일경로
	private final String DIR = "D:\\web_25226_JJH\\_myproject\\_java\\_fileUpload\\";
	
	@Scheduled(cron="00 53 17 * * *")
	public void fileSweeper() {
		log.info(">>>> FileSweeper Running Start~!! : {}", LocalDateTime.now());
		
		//DB에 등록된 모든 파일 리스트 가져오기
		List<FileVO> dbList = fdao.getAllFileList();
		
		//실제 폴더에 저장되어있는 파일리스트
		//D:\\web_25226_JJH\\_myproject\\_java\\_fileUpload\\2025\\06\\05\\uuid_fileName
		//D:\\web_25226_JJH\\_myproject\\_java\\_fileUpload\\2025\\06\\05\\uuid_th_fileName
		// (실제 존재해야 하는 파일리스트)
		List<String> currFiles = new ArrayList<>();
		for(FileVO fvo : dbList) {
			String filePath = fvo.getSaveDir()+File.separator+fvo.getUuid();
			String fileName = fvo.getFileName();
			currFiles.add(DIR+filePath+"_"+fileName);
			
			//이미지라면 썸네일도 추가
			if(fvo.getFileType() == 1) {
				currFiles.add(DIR+filePath+"_th_"+fileName);
			}
		}
		log.info(">>>> currFiles >> {}",currFiles);
		
		// 실 파일 경로 설정
		LocalDate now = LocalDate.now();
		String today = now.toString(); // 2025-06-09
		today = today.replace("-", File.separator); // 2025/06/09
		
		// 경로를 기반으로 저장되어 있는 파일을 검색
		//D:\\web_25226_JJH\\_myproject\\_java\\_fileUpload\\2025\\06\\09
		File dir = Paths.get(DIR+today).toFile();
		//listFiles() : 경로안에 있는 모든 파일을 배열로 리턴
		File[] allFileObject = dir.listFiles();
		log.info(">>> all file Object >> {}", allFileObject.toString());
		
		// 실제 저장되어 있는 파일 목록과, DB에 존재하는 파일을 비교하여 DB에 없는 파일은 삭제 진행
		for(File file : allFileObject) {
			String storedFileName = file.toPath().toString();
			if(!currFiles.contains(storedFileName)) {
				file.delete(); // 존재하지 않는다면 삭제
				log.info(">>> delete file >> {}", storedFileName);
			}
		}
		
		log.info(">>>> FileSweeper Running End~!! : {}", LocalDateTime.now());
	}	

}