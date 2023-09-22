package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Member;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		HttpSession session = request.getSession();
//		Member member = (Member)session.getAttribute("member");
//		
//		RequestDispatcher dispatcher = null;
//		if(member != null) {
//			if(member.getId().equals(id)) {
//				if(member.getPassword().equals(password)) {
//					//패스워드가 멤버의 패스워드와 일치하면 로그인 정상처리
//					session.setAttribute("id", id); 
//					// 다른 페이지에서도 로그인됐다고 알 수 있게, 아이디를 가지고 사용할 수 있게 세션에 속성으로 아이디를 넣는다
//					dispatcher = request.getRequestDispatcher("makeaccount.jsp");
//				} else {
//					//비밀번호 불일치
//					request.setAttribute("err", "비밀번호 불일치");
//					dispatcher = request.getRequestDispatcher("error.jsp");
//				}		
//			} else {
//				//id가 같지 않을때
//				request.setAttribute("err", "아이디 불일치");
//				dispatcher = request.getRequestDispatcher("error.jsp");
//			}
//		} else {
//			//member가 없음 (회원가입하지않음)
//			request.setAttribute("err", "회원가입이 되어있지 않습니다.");
//			dispatcher = request.getRequestDispatcher("error.jsp");
//		}
//		dispatcher.forward(request, response);
		request.setCharacterEncoding("utf-8");
		//1.reqeust 에서 id,password가져온다
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		//2-1.session에서 member가져온다
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		//2-2.member가 null이면 error페이지로 포워딩(회원가입해라)
		RequestDispatcher dispatcher = null;
		if(member == null) {
			request.setAttribute("err", "회원가입해라잉");
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			//3-1.가져온 member와 id를 비교
		} else if(!(id.equals(member.getId()))){
			//3-2.같지 않으면 error페이지로 포워딩(아이디가 다름)
			request.setAttribute("err", "아이디 틀렸땅ㅋㅋ");
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			//4-1.가져온 member와 password비교
		} else if(!(password.equals(member.getPassword()))) {
			//4-2.같지 않으면 error페이지로 포워딩(비밀번호가 틀림)
			request.setAttribute("err", "비번 틀렸땅ㅋㅋ");
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			
		} else {
			session.setAttribute("id", id);
			dispatcher = request.getRequestDispatcher("makeaccount.jsp");
			dispatcher.forward(request, response);
			
		}
		//5.id를 session에 넣고 makeaccount.jsp로 포워딩
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
