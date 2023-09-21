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
 * Servlet implementation class Withdraw
 */
@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("withdraw.jsp");
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
			acc.withdraw(Integer.parseInt(request.getParameter("money")));
	         request.setAttribute("acc", acc);
	         dispatcher = request.getRequestDispatcher("accountinfo.jsp");
	      } else {
	         request.setAttribute("err", "계좌번호가 틀립니다.");
	         dispatcher = request.getRequestDispatcher("error.jsp");
	      }
		dispatcher.forward(request, response);
	}

}
