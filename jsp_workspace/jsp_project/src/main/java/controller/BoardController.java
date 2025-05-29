package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.core.util.SystemClock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import handler.FileRemoveHandler;
import handler.PagingHandler;
import net.coobird.thumbnailator.Thumbnails;
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 로그객체 생성
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
    // jsp에서 받은 요청을 처리, 처리 결과를 다른 jsp로 보내주는 역할을 하는 객체
	private RequestDispatcher rdp;
	// 목적지 (jsp) 주소를 저장하는 변수
	private String destPage;
	// isOk 변수 DB 구문 체크 값 저장 변수
	private int isOk;
	// service 연결 인터페이스
	private BoardService bsv;
	
    public BoardController() {
        // 생성자 => bsv => 실제 구현 객체로 연결 생성
    	bsv = new BoardServiceImpl();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든 처리는 service 에서 처리
		log.info("BoardController test!!");
		
		//들어오는 매개변수의 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		//응답객체의 인코딩 설정
		response.setCharacterEncoding("UTF-8");
		//응답객체의 contentType 설정 => jsp 파일로 응답 (동기방식)
		response.setContentType("text/html; charset=UTF-8");
		
		//jsp에서 요청하는 주소를 받는 객체
		String uri = request.getRequestURI();
		log.info(uri); // /brd/register  => register
		
		String path = uri.substring(uri.lastIndexOf("/")+1);  //register 추출
		log.info(path);
				
		// 받은 주소에 대한 분기처리 
		switch(path) {
		case "register" : 
			destPage = "/board/register.jsp";
			break;
		case "insert" :
			try {
//				파일 첨부가 있을 경우 사용
				//파일 업로드시 사용할 물리적인 경로를 설정
				String savePath = getServletContext().getRealPath("/_fileUpload");
				log.info(">>> savePath >> {}", savePath);
				
				// File 객체 생성
				File fileDir = new File(savePath);
				log.info(">>> fileDir >> {}", fileDir);
				
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				// 파일 저장 객체 (파일 경로)
				fileItemFactory.setRepository(fileDir);
				// 파일 저장시 사용할 메모리 공간
				fileItemFactory.setSizeThreshold(1024*1024*3); // 계산 가능.
				
				BoardVO bvo = new BoardVO();
				
				// multipart/form-data 형식으로 넘어온 
				// request의 객체를 다루기 쉽게 변환해주는 클래스
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				
				List<FileItem> itemList = fileUpload.parseRequest(request);
				
				for(FileItem item : itemList) {
					// item => title, writer, content => text  imageFile => image
					switch(item.getFieldName()) {
					case "title":
						// 바이트 형태로 풀어져서 온 값을 다시 텍스트로 조합 utf-8 인코딩 해서 조합
						String title = item.getString("UTF-8");
						bvo.setTitle(title);
						break;
					case "writer":
						String writer = item.getString("UTF-8");
						bvo.setWriter(writer);
						break;
					case "content":
						String content = item.getString("UTF-8");
						bvo.setContent(content);
						break;
					case "imageFile":
						// 이미지 파일 여부 체크
						if(item.getSize()>0) {
							//파일 이름 추출  
							// getName() 경로를 포함하는 이름  ~~~/dog.jpg
							String fileName = item.getName()
									.substring(item.getName().lastIndexOf(File.separator)+1);
							// File.separator : 파일 경로 기호 => 운영체제마다 다를 수 있어서 자동 변환
							log.info(">>>> fileName >> {}", fileName);
							// 시스템의 시간을 이용하여 파일 구분  시간_파일이름 
							// UUID UUID_파일이름
							fileName = System.currentTimeMillis()+"_"+fileName;
							
							//경로 + 구분자 +파일이름 
							File uploadFile = new File(fileDir+File.separator+fileName);
							log.info(">>> uploadFile >> {}", uploadFile);
							
							// 저장
							try {
								item.write(uploadFile); // 파일 객체에 실제 데이터 쓰기
								bvo.setImageFile(fileName); // 프로젝트 내부에 저장된 이미지는 / 로 연결가능
								
								//썸네일 작업 : 리스트 페이지에서 트레픽 과다 사용 방지 (연결시간 지연 방지)
								Thumbnails.of(uploadFile)
									.size(75, 75)
									.toFile(new File(fileDir+File.separator+"_th_"+fileName));
								
							} catch (Exception e) {
								// TODO: handle exception
								log.info(">> file writer on disk error");
								e.printStackTrace();
							}
							
						}
						break;
					}
				}
				
				log.info(">> bvo {}",bvo);
				isOk = bsv.insert(bvo);
				log.info(">> insert {}", (isOk > 0)? "성공" : "실패");
				
//				파일 첨부가 없을 경우 사용  enctype="multipart/form-data" 아닐경우
//				// request 객체에 담겨 온 데이터 추출
//				String title = request.getParameter("title"); // name의 값으로 추출
//				String writer = request.getParameter("writer"); 
//				String content = request.getParameter("content");
//				
//				// DB에 넣기위해 객체 생성
//				BoardVO bvo = new BoardVO(title, writer, content);
//				log.info(">> bvo {}",bvo);
							
				// boardService 객체로 해당 객체를 전달
//				isOk = bsv.insert(bvo);
				
				// DB에서 저장이 완료되면 1이 리턴 안되면 0이 리턴
//				log.info(">> insert {}", (isOk > 0)? "성공" : "실패");
				
				destPage = "list";
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
			
		case "list": 
				try {
					// DB에서 전체 리스트를 요청
//					List<BoardVO> list = bsv.getList();
					
					PagingVO pgvo = new PagingVO();  // pageNo=1, qty=10
					
					if(request.getParameter("pageNo")!=null) {
						int pageNo = Integer.parseInt(request.getParameter("pageNo"));
						int qty = Integer.parseInt(request.getParameter("qty"));
						String type = request.getParameter("type");
						String keyword = request.getParameter("keyword");
						pgvo = new PagingVO(pageNo, qty, type, keyword);
					}
					
					// select * from board orderby bno desc limit pageStart, qty;
					// select * from board where type like "%keyword%" orderby bno desc limit pageStart, qty;
					List<BoardVO> list = bsv.getList(pgvo);
					log.info(">> list {}", list);
					
					int totalCount = bsv.getTotal(pgvo);
					log.info(">> totalCount > "+ totalCount);
					
					// 페이징 핸들러 객체 생성 => 화면으로 보내기
					PagingHandler ph = new PagingHandler(pgvo, totalCount);
					log.info(">> ph > {}", ph);
					
					// request의 객체로 값을 보내는 역할
					request.setAttribute("list", list);
					request.setAttribute("ph", ph);
					destPage="/board/list.jsp";
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			break;
		case "detail": case "modify":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				
				BoardVO bvo = bsv.getDetail(bno);
				log.info(">> detail bvo > {} ",bvo);
				request.setAttribute("bvo", bvo);
				destPage = "/board/"+path+".jsp"; 
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case "update":
			try {
				
				// 파일 업로드 포함 시
				String savePath = getServletContext().getRealPath("/_fileUpload");
				File fileDir = new File(savePath);
				
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);
				fileItemFactory.setSizeThreshold(1024*1024*3);  // 파일 저장 공간
				
				BoardVO bvo = new BoardVO();
				
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				
				List<FileItem> itemList = fileUpload.parseRequest(request);
				
				String old_file = null;  // 기존에 있던 imageFile
				
				for(FileItem item : itemList) {
					switch(item.getFieldName()) {
					case "bno":
						bvo.setBno(Integer.parseInt(item.getString("UTF-8")));
						break;
					case "title":
						bvo.setTitle(item.getString("UTF-8"));
						break;
					case "content":
						bvo.setContent(item.getString("UTF-8"));
						break;
					case "imageFile":
						// 기존 파일 => 있을 수도 있고, 없을 수도 있음.
						old_file = item.getString("UTF-8");
						break;
					case "newFile":
						// 새로 추가되는 파일 => 있을 수도 있고, 없을 수도 있음.
						if(item.getSize()>0) {
							// 새로 추가되는 파일이 있는 경우
							if(old_file != null) {
								//old_file 삭제작업
								//fileRemoveHandler 를 통해서 파일 삭제 작업 진행
								FileRemoveHandler removeHandler = new FileRemoveHandler();
								isOk = removeHandler.deleteFile(savePath, old_file);
							}
							// 새로운 파일을 등록 작업
							String fileName = item.getName()
									.substring(item.getName().lastIndexOf(File.separator)+1);
							log.info(">>>> new File >> {}", fileName);
							fileName = System.currentTimeMillis()+"_"+fileName;
							File uploadFile = new File(fileDir+File.separator+fileName);
							
							try {
								item.write(uploadFile);
								bvo.setImageFile(fileName);
								
								Thumbnails.of(uploadFile)
									.size(75,75)
									.toFile(new File(fileDir+File.separator+"_th_"+fileName));
								
							} catch (Exception e) {
								// TODO: handle exception
								log.info("file writer update Error");
								e.printStackTrace();
							}
							
						}else {
							// 기존 파일을 bvo 객체의 imageFile에 담기
							bvo.setImageFile(old_file);
						}
						break;
					}
				}
				
				int isOk = bsv.update(bvo);
				log.info(">> update bvo > {}", bvo);
				log.info(">> update {}", (isOk > 0)? "성공" : "실패");
				
//				int bno = Integer.parseInt(request.getParameter("bno"));
//				String title = request.getParameter("title");
//				String content = request.getParameter("content");
//				
//				BoardVO bvo = new BoardVO(bno, title, content);
//				log.info(">> update dbo > {}", bvo);
//				int isOk = bsv.update(bvo);
//				
//				log.info(">> update {}", (isOk > 0)? "성공" : "실패");
				
				destPage = "detail?bno="+bvo.getBno();  // 내부 케이스를 한번 더 돌아감.
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case "remove":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info(">> bno > {}", bno);
				
				String savePath = getServletContext().getRealPath("/_fileUpload");
				// 댓글, 그림 삭제 (있으면 삭제)
				BoardVO bvo = bsv.getDetail(bno); // 파라미터로 파일이름을 달면 안해도 됨. 
				log.info(">>>> bvo >> {}", bvo);
				
				int isDel = 0;
				if(bvo.getImageFile() != null) {
					FileRemoveHandler fh = new FileRemoveHandler();
					isDel = fh.deleteFile(savePath, bvo.getImageFile());
				}
				
				isOk = bsv.detele(bno);
				
				log.info(">> remove {}", (isOk > 0)? "성공" : "실패");
				destPage = "list";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		}
		
		// 처리가 완료된 만들어진 응답객체를 jsp 화면으로 보내기
		// 데이터 전달 객체 (RequestDispatcher) / 전달 jsp (destPage)
		rdp = request.getRequestDispatcher(destPage); 
		// 요청한 객체를 가지고 destPage에 적힌 주소로 이동 forword
		rdp.forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service 메서드를 호출하여 처리
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service 메서드를 호출하여 처리
		service(request, response);
	}

}