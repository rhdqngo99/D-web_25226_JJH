package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
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
				// request 객체에 담겨 온 데이터 추출
				String title = request.getParameter("title"); // name의 값으로 추출
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				
				// DB에 넣기위해 객체 생성
				BoardVO bvo = new BoardVO(title, writer, content);
				log.info(">> bvo {}",bvo);
				
				// boardService 객체로 해당 객체를 전달
				isOk = bsv.insert(bvo);
				
				// DB에서 저장이 완료되면 1이 리턴 안되면 0이 리턴
				log.info(">> insert {}", (isOk > 0)? "성공" : "실패");
				
				destPage = "/index.jsp";
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
			
		case "list": 
				try {
					// DB에서 전체 리스트를 요청
					List<BoardVO> list = bsv.getList();
					log.info(">> list {}", list);
					// request의 객체로 값을 보내는 역할
					request.setAttribute("list", list);
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
				int bno = Integer.parseInt(request.getParameter("bno"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				
				BoardVO bvo = new BoardVO(bno, title, content);
				log.info(">> update dbo > {}", bvo);
				int isOk = bsv.update(bvo);
				
				log.info(">> update {}", (isOk > 0)? "성공" : "실패");
				
				destPage = "detail";  // 내부 케이스를 한번 더 돌아감.
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case "remove":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info(">> bno > {}", bno);
				isOk = bsv.detele(bno);
				int isOk = bsv.detele(bno);
				log.info(">> update {}", (isOk > 0)? "성공" : "실패");
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
