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
 * Servlet implementation class Deposit
 */
@WebServlet("/deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	if(session.getAttribute("id") == null) {
    		request.setAttribute("err", "로그인해임마");
    		request.getRequestDispatcher("error.jsp").forward(request, response);
    		return;
    	}
		RequestDispatcher dispatcher = request.getRequestDispatcher("deposit.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		Account acc =(Account) session.getAttribute(id);
		RequestDispatcher dispatcher = null;
		if(acc != null) {
			acc.deposit(Integer.parseInt(request.getParameter("money")));
	         request.setAttribute("acc", acc);
	         dispatcher = request.getRequestDispatcher("accountinfo.jsp");
	      } else {
	         request.setAttribute("err", "계좌번호가 틀립니다.");
	         dispatcher = request.getRequestDispatcher("error.jsp");
	      }
		dispatcher.forward(request, response);
	}

}
