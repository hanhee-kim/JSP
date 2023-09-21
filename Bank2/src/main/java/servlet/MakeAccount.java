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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("makeAccount.jsp");
		dispatcher.forward(request, response);
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
		
		if(grade == null) {
			grade="";
		}
		Account acc = new Account(id, name, money, type, grade);
		HttpSession session = request.getSession();
		session.setAttribute(id, acc);  //session 의 이름이 id 값이 Account 객체 
		
		request.setAttribute("acc", acc);
		RequestDispatcher dispatcher = request.getRequestDispatcher("accountinfo.jsp");
		dispatcher.forward(request, response);
	}

}
