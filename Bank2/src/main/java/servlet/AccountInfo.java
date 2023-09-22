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
 * Servlet implementation class AccountInfo
 */
@WebServlet("/accountinfo")
public class AccountInfo extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountInfo() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	if(session.getAttribute("id") == null) {
    		request.setAttribute("err", "로그인해야 계좌 만들 수 있따잉");
    		request.getRequestDispatcher("error.jsp").forward(request, response);
    		return;
    	}
		RequestDispatcher dispatcher = request.getRequestDispatcher("accountinfoform.jsp");
		dispatcher.forward(request, response);
	}

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("utf-8");
      String id = request.getParameter("id");
      
      // session 얻어오기
      HttpSession session = request.getSession();
      Account acc = (Account) session.getAttribute(id);
      
      RequestDispatcher dispatcher = null;
      if(acc != null) {
         request.setAttribute("acc", acc);
         dispatcher = request.getRequestDispatcher("accountinfo.jsp");
      } else {
         request.setAttribute("err", "계좌번호가 틀립니다.");
         dispatcher = request.getRequestDispatcher("error.jsp");
      }
      
      dispatcher.forward(request, response);
   }

}

