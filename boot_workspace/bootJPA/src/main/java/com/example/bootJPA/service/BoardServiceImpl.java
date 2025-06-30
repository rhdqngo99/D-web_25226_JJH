package com.example.bootJPA.service;

import com.example.bootJPA.dto.BoardDTO;
import com.example.bootJPA.dto.BoardFileDTO;
import com.example.bootJPA.dto.FileDTO;
import com.example.bootJPA.entity.Board;
import com.example.bootJPA.entity.File;
import com.example.bootJPA.repository.BoardRepository;
import com.example.bootJPA.repository.FileRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;
    private final FileRepository fileRepository;

    @Transactional
    @Override
    public Long insert(BoardFileDTO boardFileDTO) {
        // 저장 객체는 Board
        // save() : 저장
        // entity 객체를 파라미터로 전송
        BoardDTO boardDTO = boardFileDTO.getBoardDTO();
        boardDTO.setFileQty(boardFileDTO.getFileList().size());
        Long bno = boardRepository.save(convertDtoToEntity(boardDTO)).getBno();
        bno = fileSave(boardFileDTO.getFileList(), bno);

        /* 하단 메서드로 분리 => fileSave()
        if(bno > 0 && boardFileDTO.getFileList() != null){
            for(FileDTO fileDTO : boardFileDTO.getFileList()){
                fileDTO.setBno(bno);
                bno = fileRepository.save(convertDtoToEntity(fileDTO)).getBno();
            }
        }*/

        return bno;
    }

    @Override
    public Long insert(BoardDTO boardDTO) {
        return boardRepository.save(convertDtoToEntity(boardDTO)).getBno();
    }

    private long fileSave(List<FileDTO> fileList, long bno){
        if(bno > 0 && fileList != null){

            for(FileDTO fileDTO : fileList){
                fileDTO.setBno(bno);
                bno = fileRepository.save(convertDtoToEntity(fileDTO)).getBno();
            }
        }
        return bno;
    }

    @Override
    public List<BoardDTO> getList() {
        /* controller로 List<BoardDTO>
         * DB에서 가져오는 리턴은 List<Board> => List<BoardDTO> 로 변환
         * select * from board order by bno desc
         * findAll => 전체 값 리턴
         * 정렬 : Sort.by(Sort.Direction.DESC, "정렬기준 칼럼명")
         * findById => where id=id  id가 일치하는 값 리턴
         * */
        List<Board> boardList = boardRepository.findAll(
                Sort.by(Sort.Direction.DESC, "bno"));

        /* List<BoardDTO> boardDTOList = new ArrayList<>();
        for(Board board : boardList){
            boardDTOList.add(convertEntityToDto(board));
        } */

        List<BoardDTO> boardDTOList = boardList.stream()
                .map(board -> convertEntityToDto(board)).toList();

        return boardDTOList;
    }

    @Override
    public Page<BoardDTO> getPageList(int pageNo) {
        /* limit 시작번지, 개수  => 시작번지는 0부터 시작
         * pageNo = 0  => limit 0, 10
         * pageNo = 1
         * */
        Pageable pageable = PageRequest.of(pageNo, 10,
                Sort.by("bno").descending());
        Page<Board> list = boardRepository.findAll(pageable);
        Page<BoardDTO> boardDTOPageList = list.map(this::convertEntityToDto);
        return boardDTOPageList;
    }

    @Override
    public Page<BoardDTO> getList(int pageNo, String type, String keyword) {
        Pageable pageable = PageRequest.of(pageNo, 10,
                Sort.by("bno").descending());
        Page<Board> list = boardRepository.searchBoard(type,keyword,pageable);
        log.info(">>> list serviceImpl >> {}", list.getContent());
        Page<BoardDTO> boardDTOList = list.map(this::convertEntityToDto);
        log.info(">>> boardDTOList serviceImpl >> {}", boardDTOList.getContent());
        return boardDTOList;
    }

    @Transactional
    @Override
    public BoardFileDTO getDetail(Long bno) {
        /* findById =>  where bno = #{bno}
         * Optional<T> : NullPointException이 발생하지 않도록 도와줌.
         * Optional.isEmpty() : null 일 경우 true / false
         * Optional.isPresent() : 값이 있는지를 확인 true / false
         * Optional.get() : 객체 가져오기
         * */
        Optional<Board> optional = boardRepository.findById(bno);
        if(optional.isPresent()) {
            Board board = optional.get();
            int count = board.getReadCount()+1;
            board.setReadCount(count);
            boardRepository.save(board);
            BoardDTO boardDTO = convertEntityToDto(optional.get());
            // file bno 에 일치하는 파일 리스트 가져오기
            List<File> fList = fileRepository.findByBno(bno);
            List<FileDTO> fileDTOList = fList.stream()
                    .map(this::convertEntityToDto)
                    .toList();
            BoardFileDTO boardFileDTO = new BoardFileDTO(boardDTO, fileDTOList);
            return boardFileDTO;
        }
        return null;
    }

    @Transactional
    @Override
    public Long modify(BoardFileDTO boardFileDTO) {
        // Optional<Board> optional = boardRepository.findById(boardDTO.getBno());
        // optional.orElseThrow(() -> new EntityNotFoundException("존재하지 않는 게시글"));
        // Board board = optional.get();
        Board board = boardRepository.findById(boardFileDTO.getBoardDTO().getBno())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 게시글"));

        board.setTitle(boardFileDTO.getBoardDTO().getTitle());
        board.setContent(boardFileDTO.getBoardDTO().getContent());
        if(boardFileDTO.getFileList() != null){
            board.setFileQty(board.getFileQty()+boardFileDTO.getFileList().size());
        }
        long bno = fileSave(boardFileDTO.getFileList(), board.getBno());

        /*
        메서드로 분리 => fileSave()
        if(boardFileDTO.getFileList() != null){
            for(FileDTO fileDTO : boardFileDTO.getFileList()){
                fileDTO.setBno(board.getBno());
                bno = fileRepository.save(convertDtoToEntity(fileDTO)).getBno();
            }
        }*/

        return bno;
    }

    @Override
    public void remove(Long bno) {
        // 삭제 : deleteById(id)
        boardRepository.deleteById(bno);
    }

    @Transactional
    @Override
    public long fileRemove(String uuid) {
        Optional<File> file = fileRepository.findById(uuid);
        if(file.isPresent()){
            Optional<Board> optional = boardRepository.findById(file.get().getBno());
            if(optional.isPresent()){
                Board board = optional.get();
                board.setFileQty(board.getFileQty()-1);
            }
            fileRepository.deleteById(uuid);
        }
        return file.get().getBno();
    }

    /* save() => id 가 없으면 insert / id가 있으면 update
     * id가 where 상에서 존재하지 않는다면 DB상에 에러가 생김. (EntityNotFoundException 발생)
     * 정보 유실에 대한 위함이 커짐.
     * 없는 정보에 대한 (reg_date 같은 경우 데이터가 사라짐)
     * 변동감지 (Dirty Checking) 미작동 가능성이 커짐.
     *
     * findById(bno) 를 통해 먼저 조회 => 영속상태를 만든 후 수정 => save()
     *
     * @Transactional  Dirty Checking만으로 업데이트 가능  / save() 없이도 가능.
     * UPDATE만 가능.
     *
     * Dirty Checking(더티 체킹)
     * 엔티디가 영속성 컨텍스트에 올라가있는 상태 (=영속상태) 일 때,
     * 해당 객체의 필드가 변경되면, 트랜젝션이 종료되기 전에 JPA가 변경한 부분만
     * 자동 감지하여 UPDATE 쿼리를 실행.
     * save() 없이(명시적으로 호출하지 않아도) 수정된 필드를 DB에 자동반영
     * */

    /* @Override
    public Long modify(BoardDTO boardDTO) {
        // JPA 에서는 update 구문이 없음.
        // 기존 객체를 가져와서 set 수정 후 다시 저장
        Optional<Board> optional = boardRepository.findById(boardDTO.getBno());
        if(optional.isPresent()){
            Board entity = optional.get();
            entity.setTitle(boardDTO.getTitle());
            entity.setContent(boardDTO.getContent());
            // 다시 저장
            return boardRepository.save(entity).getBno();
        }
        return 0L;
    } */
}