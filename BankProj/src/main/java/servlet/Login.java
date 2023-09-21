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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		if(member != null) {
			if(member.getId().equals(id)) {
				if(member.getPassword().equals(password)) {
					//패스워드가 멤버의 패스워드와 일치하면 로그인 정상처리
					session.setAttribute("id", id); 
					// 다른 페이지에서도 로그인됐다고 알 수 있게, 아이디를 가지고 사용할 수 있게 세션에 속성으로 아이디를 넣는다

					request.setAttribute("page", "makeaccount");
				} else {
					//비밀번호 불일치
					request.setAttribute("err", "비밀번호 불일치");
					request.setAttribute("page", "error");
				}		
			} else {
				//id가 같지 않을때
				request.setAttribute("err", "아이디 불일치");
				request.setAttribute("page", "error");
			}
		} else {
			//member가 없음 (회원가입하지않음)
			request.setAttribute("err", "회원가입이 되어있지 않습니다.");
			request.setAttribute("page", "error");
		}
		dispatcher.forward(request, response);
	}

}
