package open.the.wardrobe.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import open.the.wardrobe.member.model.service.MemberService;
import open.the.wardrobe.member.model.vo.Member;


/**
 * Servlet implementation class MyInfoController
 */
@WebServlet("/member/myInfo.do")
public class MyInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 페이지 이동 2가지
		// 1. with Data (<- DataBase에서 가져옴)
		// 쿼리문 : SELECT * FROM MB_TBL WHERE MBUSER_ID = ?
		MemberService service = new MemberService();
		String userId = request.getParameter("userId");
		Member member = service.selectOneById(userId);  //서비스에 있는 메소드 호출
		request.setAttribute("member", member);  // 앞에는 String이라서 쌍따옴표를 써야하고, 콤마뒤 2번째항에는 쌍따옴표 XXXX
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/myInfo22.jsp");
		view.forward(request, response);
		// 2. without Data(단순 페이지 이동)
//		response.sendRedirect("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
