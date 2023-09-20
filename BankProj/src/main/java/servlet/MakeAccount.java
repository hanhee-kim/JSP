package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;

/**
 * Servlet implementation class MakeAccount
 */
@WebServlet("/makeAccount")
public class MakeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Integer money = Integer.parseInt(request.getParameter("money"));
		String type = request.getParameter("type");
		String grade = request.getParameter("grade");
		
		Account acc = new Account(id, name, money, type, grade);
		HttpSession session = request.getSession();
		session.setAttribute(id, acc);  //session 의 이름이 id 값이 Account 객체 
		
		request.setAttribute("acc", acc);
		request.setAttribute("page", "accountinfo");
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
		//세션의 속성이름이 acc인 Account객체 acc를 세션으로 set, page이름은 accountinfo
		//requestDispatcher를 통해 main.jsp로 이동.
	}

}
