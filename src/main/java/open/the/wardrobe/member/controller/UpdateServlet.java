package open.the.wardrobe.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import open.the.wardrobe.member.model.service.MemberService;
import open.the.wardrobe.member.model.vo.Member;


/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/member/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); // 한글아 깨지지마!~
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");
		String choice1 = request.getParameter("cellphone[]");
		String tel = request.getParameter("phone");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String choice2 = request.getParameter("email[]");
		String gender = request.getParameter("member-gender");
		String height = request.getParameter("label[1][value][]");
		String weight = request.getParameter("label[3][value][]");
		String footSize = request.getParameter("label[9][value][]");
		// UPDATE MEMBER_TBL SET MEMBER_PW = ?, MEMBER_EMAIL = ?, MEMBER_PHONE = ?, MEMBER_ADDRESS = ?, MEMBER_HOBBY = ?, UPDATE_DATE = SYSDATE WHERE MEMBER_ID = ?
		MemberService service = new MemberService();
//		Member member = new Member(memberId, memberPw, memberEmail, memberPhone, memberAddress, memberHobby);
		Member member = new Member(userId, password, choice1, tel, userName, email, choice2, gender, height, weight, footSize);
//		int result = service.updateMember(memberId, memberPw, memberEmail, memberPhone, memberAddress, memberHobby);
		int result = service.updateMember(member);
		if(result > 0) {
			// 성공(하면 메인페이지)
			response.sendRedirect("/main/main.jsp");
		}else {
			// 실패(하면 에러페이지)
			request.setAttribute("msg", "회원 수정이 완료되지 않았습니다.");
			request.getRequestDispatcher("/member/serviceFailed.jsp").forward(request, response);
		}
	}

}
