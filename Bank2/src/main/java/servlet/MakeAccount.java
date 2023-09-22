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
@WebServlet("/makeaccount")
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
    	HttpSession session = request.getSession();
    	if(session.getAttribute("id") == null) {
    		request.setAttribute("err", "로그인해야 계좌 만들 수 있따잉");
    		request.getRequestDispatcher("error.jsp").forward(request, response);
    		return;
    	}
		RequestDispatcher dispatcher = request.getRequestDispatcher("makeaccount.jsp");
		dispatcher.forward(request, response);
		//request는 내가 요청하기전의 페이지의 모든 정보를 담고있으며,
		//forward를 사용하면 request에 담긴 내용을 가지고 전달한다.
		//doGet에서는 사실상 담고있는 정보가 없기 때문에 sendredirect를 사용해도 된다.
		//sendredirect할때 페이지를 재요청해서 가지고 있는것. 즉 정보를 담아가지고 갈 수 없다.
		//하지만 session에 담긴 정보는 사용이 가능하다.(session은 같은 프로젝트 내에 있는 모든 경로에서 사용이 가능하기 때문)
//		response.sendRedirect("makeAccount.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); 
	
		 
		
//		 * 1.request로부터 입력값 가져온다.
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Integer money = Integer.parseInt(request.getParameter("money"));
		String type = request.getParameter("type");
		String grade = request.getParameter("grade");
		
		if(grade == null) {
			grade="";
		}
//		 * 2.Account 객체 생성
		Account acc = new Account(id, name, money, type, grade);
//		 * 3.Session얻어온다
		HttpSession session = request.getSession();
//		 * 4.생성된 Account객체를 session에 저장
		session.setAttribute(id, acc);  //session 의 이름이 id 값이 Account 객체 
		
//		 * 5.생성된 Account 객채를 request에 넣음
		request.setAttribute("acc", acc);
//		 * 6.accountinfo.jsp로 포워드
		RequestDispatcher dispatcher = request.getRequestDispatcher("accountinfo.jsp");
		dispatcher.forward(request, response);
	}

}
