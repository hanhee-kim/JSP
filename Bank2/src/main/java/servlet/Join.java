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
 * Servlet implementation class Join
 */
@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Join() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("join.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id 		= request.getParameter("id");
		String name 	= request.getParameter("name");
		String password = request.getParameter("password");
		String email	= request.getParameter("email");
		String address  = request.getParameter("address");
		RequestDispatcher dispatcher = null;
		
		if((id.trim() == "" || id == null)
			|| (name.trim() 	== "" 	|| name == null)
			|| (password.trim() == "" 	|| password == null )
			|| (email.trim() 	== "" 	|| email == null) 
			|| (address.trim() 	== "" 	|| address == null)
		){
			
			request.setAttribute("err", "회원가입 양식을 확인하세요");
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
		else {
		Member member = new Member(id, name, password, email, address);
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		}
	}
}
