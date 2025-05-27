package handler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileRemoveHandler {
	private static final Logger log = LoggerFactory.getLogger(FileRemoveHandler.class);
	
	// 파일경로, 파일 이름 (컨트롤러에서 매개변수로 전달)
	// 파일을 생성 => 같은 파일이 존재하면 삭제 (썸네일도 같이 삭제)
	public int deleteFile(String savePath, String fileName) {
		
		boolean isDel = false; // 삭제가 잘 되었는지 체크하는 변수
		log.info(">>> deleteFileName >> {}", fileName);
		
		// 기존 파일 객체 , 썸네일 파일 객체
		File fileDir = new File(savePath);
		File removeFile = new File(fileDir + File.separator + fileName);
		File removeThumbFile = new File(fileDir + File.separator +"_th_"+ fileName);
		
		// 파일이 존재해야 삭제
		if(removeFile.exists()) {
			isDel = removeFile.delete(); // 같은 이름의 파일을 삭제
			log.info(">>> fileRemove >> {}", isDel);
			if(isDel && removeThumbFile.exists()) {
				isDel = removeThumbFile.delete();
				log.info(">>> removeThumbRemove >> {}", isDel);
			}
		}
		
		return isDel ? 1: 0;
	}

}
