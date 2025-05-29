package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import service.CommentService;
import service.CommentServiceImpl;

@WebServlet("/cmt/*")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CommentController.class);
    
	// 비동기 방식 : 데이터를 요청한 곳으로 결과를 (객체형태 또는 텍스트) 바로 보내주는 방식
	// RequestDispatcher / destPage / setContentType => 필요가 없음.
	
	private CommentService csv;
	private int isOk;

    public CommentController() {
        csv = new CommentServiceImpl();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든 요청을 받아서 한번에 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI(); // /cmt/register
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(">>> cmt path > {}", path);
		
		switch(path) {
		case "post":
			try {
				log.info("post Controller check 1");
				// 동기방식에서는 request.getParameter 
				// 비동기방식 => request.getReader()  // 객체를 읽어들어야 함
				BufferedReader br = request.getReader(); // 댓글 객체
				StringBuffer sb = new StringBuffer();
				String line = "";
				while((line = br.readLine()) != null) {
					sb.append(line);
				}
				log.info(">>>> sb > {}", sb.toString());
				
				// String -> 객체로 생성 (json-simple 라이브러리 이용)
				// String -> json 형태로 parser => JsonObject => key:value => CommentVO
				//{"bno":"55","writer":"111","content":"11111"}
				JSONParser parser = new JSONParser();
				JSONObject jsonobj = (JSONObject)parser.parse(sb.toString());
				log.info(">>>> jsonobj > {}",jsonobj);
				int bno = Integer.parseInt(jsonobj.get("bno").toString());
				String writer = jsonobj.get("writer").toString();
				String content = jsonobj.get("content").toString();
				
				CommentVO cvo = new CommentVO(bno, writer, content);
				log.info(">>>> cvo > {}", cvo);
				
				isOk = csv.post(cvo);
				log.info(">>> post > {}",(isOk > 0)?"성공" : "실패");
				
				// 화면으로 데이터를 전송(response 객체의 body에 기록) 
				PrintWriter out = response.getWriter();
				out.print(isOk);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case "list":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info(">>>> bno > {}", bno);
				
				List<CommentVO> list = csv.getList(bno);
				log.info(">>>> list > {}", list);
				
				// List<CommentVO> => json 변환 후 보내기
				// [{...},{...},{...}, ...]     [] JSONArray  {...} JSONObject
				JSONArray jsonArray = new JSONArray(); // []
				for(int i=0; i< list.size(); i++) {
					JSONObject obj = new JSONObject(); // {}
					obj.put("cno", list.get(i).getCno());
					obj.put("bno", list.get(i).getBno());
					obj.put("writer", list.get(i).getWriter());
					obj.put("content", list.get(i).getContent());
					obj.put("regdate", list.get(i).getRegdate());
					
					jsonArray.add(obj);
				}
				log.info(">>>> jsonArray > {}",jsonArray);
				// [{...},{...},{...}, ...]	 obj =>String으로 변환하여 전송	
				String jsonData = jsonArray.toJSONString();
				
				PrintWriter out = response.getWriter();
				out.print(jsonData);
						
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case "modify":
			try {
				BufferedReader br = request.getReader();
				StringBuffer sb = new StringBuffer();
				String line ="";
				while((line = br.readLine())!=null) {
					sb.append(line);
				}
				
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject)parser.parse(sb.toString());
				
				int cno = Integer.parseInt(jsonObj.get("cno").toString());
				String content = jsonObj.get("content").toString();
				
				CommentVO cvo = new CommentVO(cno, content);
				log.info(">>>> modify cvo {}", cvo);
				isOk = csv.modify(cvo);
				log.info(">>> modify > {}",(isOk > 0)?"성공" : "실패");
				
				PrintWriter out = response.getWriter();
				out.print(isOk);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case "remove":
			try {
				int cno = Integer.parseInt(request.getParameter("cno"));
				
				isOk = csv.delete(cno);
				log.info(">>> remove > {}",(isOk > 0)?"성공" : "실패");
				PrintWriter out = response.getWriter();
				out.print(isOk);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 방식으로 오는 요청을 처리 => service를 호출하여 처리
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식으로 오는 요청을 처리 => service를 호출하여 처리
		service(request, response);
	}

}