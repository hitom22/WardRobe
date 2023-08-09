package open.the.wardrobe.member.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import open.the.wardrobe.member.model.dao.MemberDAO;
import open.the.wardrobe.member.model.vo.Member;

public class MemberService {
	
	private JDBCTemplate jdbcTemplate;
	private MemberDAO mDao;
	
	public MemberService() {
		jdbcTemplate = JDBCTemplate.getInstance();
		mDao = new MemberDAO();
	}
	
	// 연결생성
	// DAO 호출
	// 커밋/롤백
	
	public int insertMember(Member member) {
		Connection conn = jdbcTemplate.createConnection();
		int result = mDao.insertMember(conn, member);
		if(result > 0) {
			jdbcTemplate.commit(conn);
		}else {
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}

	public Member selectCheckLogin(Member member) {
		// TODO Auto-generated method stub
		// 연결생성
		Connection conn = jdbcTemplate.createConnection();
		// DAO 호출
		Member mOne = mDao.selectCheckLogin(conn, member);
		jdbcTemplate.close(conn);
		return mOne;
	}

	public Member selectOneById(String userId) {
		// TODO Auto-generated method stub
		// 연결생성
		Connection conn = jdbcTemplate.createConnection();
		// DAO 호출(연결도 넘겨줘야 함)
		Member member = mDao.selectOneById(conn, userId);
		jdbcTemplate.close(conn);
		return member;
	}

	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		// 연결생성
		Connection conn = jdbcTemplate.createConnection();
		// DAO 호출
		int result = mDao.updateMember(conn, member);
		// 커밋/롤백
		if(result>0) {
			// 성공 - 커밋
			jdbcTemplate.commit(conn);
		}else {
			// 실패 - 롤백
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}
	
	
}
