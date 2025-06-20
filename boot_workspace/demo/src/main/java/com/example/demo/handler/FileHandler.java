package com.example.demo.handler;

import com.example.demo.domain.FileVO;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class FileHandler {
    /* 파일을 폴더에 저장하고, fileList를 리턴하는 클래스 */

    private final String UP_DIR = "D:\\web_25226_JJH\\_myproject\\_java\\_fileUpload";

    public List<FileVO> uploadFiles(MultipartFile[] files){
        List<FileVO> fileList = new ArrayList<>();
        // 날짜 형태로 폴더를 구성
        LocalDate date = LocalDate.now(); // 2025-06-19
        String today = date.toString().replace("-", File.separator); // 2025\\06\\19
        // D:\web_25226_JJH\_myproject\_java\_fileUpload\2025\06\19 => File 객체 생성
        File folders = new File(UP_DIR, today);

        // 해당 폴더가 없으면 생성  mkdir (1개폴더 생성) / mkdirs (여러개 동시 생성)
        if(!folders.exists()){
            folders.mkdirs();  // 한번에 여러개 생성
        }

        // FileVO 생성 : 각자 파일마다 생성
        for(MultipartFile file : files){
            // file : name, size, type
            log.info(">>> file type (file.getContentType()) >> {}", file.getContentType());
            FileVO fileVO = new FileVO();
            fileVO.setSaveDir(today);
            fileVO.setFileSize(file.getSize());
            String fileVOName = file.getOriginalFilename();
            fileVO.setFileName(fileVOName);

            UUID uuid = UUID.randomUUID();
            String uuidStr = uuid.toString();
            fileVO.setUuid(uuidStr);
            int type = file.getContentType().startsWith("image") ? 1 : 0;
            fileVO.setFileType(type);

            log.info(">>> fileVO >> {}", fileVO);

            // -------file save
            String fileName = uuidStr+"_"+fileVOName;
            String fileThName = uuidStr+"_th_"+fileVOName;

            // 실 저장 파일
            File storeFile = new File(folders, fileName);

            try {
                file.transferTo(storeFile);
                // 그림파일만 썸네일 작업
                if(type == 1){
                    File thumbnail = new File(folders, fileThName);
                    Thumbnails.of(storeFile)
                            .size(100,100).toFile(thumbnail);
                }
            } catch (Exception e) {
                log.info("file save error");
                e.printStackTrace();
            }
            fileList.add(fileVO);

        }

        return fileList;
    }
}