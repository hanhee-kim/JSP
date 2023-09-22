package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;

/**
 * Servlet implementation class Allaccountinfo
 */
@WebServlet("/allaccountinfo")
public class Allaccountinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Allaccountinfo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	if(session.getAttribute("id") == null) {
    		request.setAttribute("err", "로그인해야야야야");
    		request.getRequestDispatcher("error.jsp").forward(request, response);
    		return;
    	}
		//1.session에 있는 모든 키 목록을 가져온다.
//		HttpSession session = request.getSession();		
		Enumeration<String> e =	session.getAttributeNames(); // getAttributeNames()의 리턴타입이 Enumeration임
		//2.Account 목록을 담은 ArrayList 생성
		List<Account> accs = new ArrayList<>();
		//3.데이터를 가져온다.
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			//회원가입시 로그인시 세션에 넣을건데 섞여있음 ( 멤버나 아이디는 걸러주고 = 계좌번호가 아닌 session의 key(속성명) )
			System.out.println(name);
			if(name.equals("member") || name.equals("id")) continue;
			//멤버나 아이디가 아니면 Account로 만들어준다.
			Account acc = (Account)session.getAttribute(name);
			accs.add(acc); //Account배열 accs에 넣어줌
		}
		RequestDispatcher dispatcher = null;
		
		
		if(accs.size() > 0 ) {
			request.setAttribute("accs", accs);
			dispatcher = request.getRequestDispatcher("allaccountinfo.jsp");
		} else {
			request.setAttribute("err", "개설된 계좌가 없음");
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		dispatcher.forward(request, response);
	}

}
