package com.berry.project.handler;

import com.berry.project.dto.CustomerIqFileDTO;
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
public class CustomerIqFileHandler {

  private final String UP_DIR = "D:\\berry_file\\";

  public List<CustomerIqFileDTO> uploadFiles(MultipartFile[] files) {

    List<CustomerIqFileDTO> fileList = new ArrayList<>();

    // 날짜 폴더 경로 생성
    LocalDate date = LocalDate.now();
    String today = date.toString().replace("-", File.separator);
    File folders = new File(UP_DIR, today);
    if (!folders.exists()) {
      folders.mkdirs();
    }

    // 파일별 처리
    for (MultipartFile file : files) {
      if (file.isEmpty()) continue;

      String originalName = file.getOriginalFilename();
      String uuid = UUID.randomUUID().toString();
      String saveName = uuid + "_" + originalName;
      String thumbnailName = uuid + "_th_" + originalName;
      String saveDir = today;

      File saveFile = new File(folders, saveName);

      try {
        file.transferTo(saveFile);

        // 썸네일 생성 (이미지인 경우)
        int fileType = file.getContentType().startsWith("image") ? 1 : 0;
        if (fileType == 1) {
          File thumbnail = new File(folders, thumbnailName);
          Thumbnails.of(saveFile).size(100, 100).toFile(thumbnail);
        }

        // DTO 생성
        CustomerIqFileDTO dto = CustomerIqFileDTO.builder()
            .fileName(originalName)
            .uuid(uuid)
            .saveDir(saveDir)
            .fileSize(file.getSize())
            .fileType(fileType)
            .build();

        fileList.add(dto);

      } catch (Exception e) {
        log.error("파일 저장 실패: {}", e.getMessage());
        e.printStackTrace();
      }
    }

    return fileList;
  }
}
