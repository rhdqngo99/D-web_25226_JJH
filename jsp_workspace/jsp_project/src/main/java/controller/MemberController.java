package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	// requestDispatcher : 요청에 대한 응답 데이터를 jsp 전송하는 역할
	private RequestDispatcher rdp;
	// jsp의 주소를 저장하는 변수
	private String destPage;
	//isOk
	private int isOk;
	
	//service interface
	private MemberService msv;
       

    public MemberController() {
        msv = new MemberServiceImpl(); // MemberService interface 구현체
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get / post  => service에서 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// uri 경로 
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(path);
		
		switch(path) {
		case "register" :
			// index의 회원가입 버튼 클릭시 화면 이동
			destPage = "/member/register.jsp";
			break;
			
		case "insert":
			try {
				// jsp에서 보낸 파라미터 값 받기
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				
				MemberVO mvo = new MemberVO(id, pwd, email, phone);
				
				isOk = msv.insert(mvo);
				log.info(">>> insert mvo >> {}", mvo);
				log.info(">>> insert isOk >> {}", (isOk>0)?"성공":"실패");
				destPage = "/index.jsp";
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case "login":
			try {
				/* 1. jsp에서 보내온 id, pwd 받기
				 * 2. id, pwd로 객체를 생성 => DB로 전송
				 * 3. 해당 id, pwd 가 일치하는 객체가 있는지 확인
				 * 4. 객체를 컨롤러로 가져와서 세션객체에 값을 저장
				 * session : 모든 jsp에서 공유되는 객체 / 브라우저가 종료되면 삭제
				 * */
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				MemberVO mvo = new MemberVO(id, pwd);
				
				// id와 pwd 가 일치하는 객체를 리턴
				MemberVO loginMvo = msv.login(mvo);
				log.info(">>>> login mvo {}", loginMvo);
				
				// loginMvo 가 일치하는 값이 없다면 null
				if(loginMvo != null) {
					//session에 저장
					//session 객체 가져오기
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", loginMvo);
					ses.setMaxInactiveInterval(10*60); // 로그인 유지시간 초단위 설정 10분
				}else {
					// 로그인 객체가 없다면....
					// index.jsp (로그인 페이지가 있다면 로그인페이지로...) 로 값을 전송
					request.setAttribute("msg_login", -1);
				}
				
				destPage = "/index.jsp";
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case "logout":
			try {
				// 세션 객체에 값이 있다면 끊기
				HttpSession ses = request.getSession();
				MemberVO mvo = (MemberVO)ses.getAttribute("ses");
				log.info(">>> logout mvo {}", mvo);
				// lastlogin 날짜 기록 update
				isOk = msv.lastloginUpdate(mvo.getId());
				log.info(">>> lastloginUpdate isOk >> {}", (isOk>0)?"성공":"실패");
				// 세션을 무효화 (세션끊기)
				ses.invalidate();
				// session의 객체를 지우기
				//ses.removeAttribute("ses");
				destPage="/index.jsp";
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case "list":
			try {
				List<MemberVO> list = msv.getList();
				log.info(">>>> list >> {}", list);
				request.setAttribute("list", list);
				destPage="/member/list.jsp";
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
			
		case "modify":
			destPage="/member/modify.jsp";
			break;
			
		case "update":
			try {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				
				MemberVO mvo = new MemberVO(id, pwd, email, phone);
				log.info(">>> update mvo >> {}", mvo);
				
				isOk = msv.update(mvo);
				log.info(">>> update isOk >> {}", (isOk>0)?"성공":"실패");
				
				//세션을 끊고, 다시 로그인 할 수 있게 유도
				if(isOk >0) {
					HttpSession ses = request.getSession(); // 로그인한 세션을 가져와서
					ses.invalidate(); //세션을 끊어라
					request.setAttribute("msg_update", "ok");
					destPage="/index.jsp";
				}else {
					request.setAttribute("msg_update", "fail");
					destPage = "/member/modify.jsp";
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
			
		case "remove":
			try {
				HttpSession ses = request.getSession();
				String id = ((MemberVO)ses.getAttribute("ses")).getId();
				log.info(">>> delete id >> {}",id);
				isOk = msv.delete(id);
				log.info(">>> delete isOk >> {}", (isOk>0)?"성공":"실패");
				
				if(isOk > 0) {
					// 삭제(DB에서 삭제) 되었다면 세션 끊기
					ses.invalidate();
					request.setAttribute("msg_delete", "ok");
				}
				destPage="/index.jsp";
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		
		}
		// 목적지로 이동
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

}