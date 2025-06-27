package com.example.bootJPA.handler;

import com.example.bootJPA.entity.File;
import com.example.bootJPA.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
@EnableScheduling
public class FileSweeper {
    /* 매일 정해진 시간에 스케줄러를 실행
        매일 등록된 파일과 (DB) 해당일자의 폴더의 파일과 일치하는지 비교
        일치하는 파일(DB = file)은 남기고, (DB != file) DB에 없는 파일은 삭제
    *   직접 DB에서 조회 => FileRepository 연결
    * */
    private final FileRepository fileRepository;
    private final String BASE_PATH ="D:\\web_25226_JJH\\_myproject\\_java\\_fileUpload";

    // cron방식 = 초 분 시 일 월 요일 년도(생략가능)
    @Scheduled(cron = "0 12 17 * * *")
    public void fileSweeper(){
        log.info(">>>>>>>> FileSweeper Running Start >> {}", LocalDateTime.now());
        // DB에 등록되어 있는 모든 파일 목록을 가져오기
        List<File> dbList = fileRepository.findAll();

        // 파일경로+파일명을 붙인 실제 파일 리스트 생성
        // "D:\web_25226_JJH\_myproject\_java\_fileUpload\2025\06\26\ uuid_파일명"
        // "D:\web_25226_JJH\_myproject\_java\_fileUpload\2025\06\26\ uuid_th_파일명"
        List<String> currFiles = new ArrayList<>();
        for(File fvo : dbList){
            String filePath = fvo.getSaveDir()+ java.io.File.separator
                    +fvo.getUuid();
            String fileName = fvo.getFileName();
            currFiles.add(BASE_PATH+filePath+"_"+fileName);

            //이미지만 썸네일이 있음. (썸네일 경로도 추가)
            if(fvo.getFileType() == 1){
                currFiles.add(BASE_PATH+filePath+"_th_"+fileName);
            }
        }
        log.info(">>>>>> currFiles(DB) >> {}", currFiles);

        //실제 저장되어 있는 파일 목록과, DB의 파일을 비교하여 DB에 없는 파일은 삭제 진행
        //오늘날짜의 파일 경로 설정
        LocalDate now = LocalDate.now();
        String today = now.toString();
        today = today.replace("-", java.io.File.separator);

        //D:\web_25226_JJH\_myproject\_java\_fileUpload\2025\06\26
        // 오늘날짜 폴더 안에 있는 파일의 목록을 검색
        java.io.File dir = Paths.get(BASE_PATH+today).toFile();
        // 전체 객체를 배열로 나눠서 리턴
        java.io.File[] fileObject = dir.listFiles();
        log.info(">>>>>> fileObject(폴더) >> {}", fileObject.toString());

        // 두 목록 비교 후 DB에 없는 파일은 삭제
        for(java.io.File file : fileObject){
            // "D:\web_25226_JJH\_myproject\_java\_fileUpload\2025\06\26\ uuid_파일명"
            String storedFileName = file.toPath().toString();
            if(!currFiles.contains(storedFileName)){
                //삭제
                file.delete();
                log.info(">>>>>> deleteFile >> {}", storedFileName);
            }
        }
        log.info(">>>>>>>> FileSweeper Running End >> {}", LocalDateTime.now());
    }
}