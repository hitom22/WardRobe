package open.the.wardrobe.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import open.the.wardrobe.member.model.vo.Member;

public class MemberDAO {

	public int insertMember(Connection conn, Member member) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO MB_TBL VALUES(?,?,?,?,?,?,?,?,?,?,?,DEFAULT,DEFAULT,DEFAULT)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getChoice1());
			pstmt.setString(4, member.getTel());
			pstmt.setString(5, member.getUserName());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getChoice2());
			pstmt.setString(8, member.getGender());
			pstmt.setString(9, member.getHeight());
			pstmt.setString(10, member.getWeight());
			pstmt.setString(11, member.getFootSize());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Member selectCheckLogin(Connection conn, Member member) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MB_TBL WHERE MB_USERID = ? AND MB_PASSWORD = ?";
		Member mOne = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getPassword());
			rset = pstmt.executeQuery();	// 누락 주의, 결과값 받기 주의
			if(rset.next()) {
				mOne = rsetToMember(rset);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mOne;
	}

	public Member selectOneById(Connection conn, String userId) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MB_TBL WHERE MB_USERID = ?";
		Member mOne = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();	// 누락 주의, 결과값 받기 주의
			if(rset.next()) {
				mOne = rsetToMember(rset);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mOne;
	}

	private Member rsetToMember(ResultSet rset) throws SQLException {
		// TODO Auto-generated method stub
		Member member = new Member();
		member.setUserId(rset.getString("MB_USERID"));
		member.setPassword(rset.getString("MB_PASSWORD"));
		member.setChoice1(rset.getString("MB_CHOICE1"));
		member.setTel(rset.getString("MB_TEL"));
		member.setUserName(rset.getString("MB_NAME"));
		member.setEmail(rset.getString("MB_EMAIL"));
		member.setChoice2(rset.getString("MB_CHOICE2"));
		member.setGender(rset.getString("MB_GENDER"));
		member.setHeight(rset.getString("MB_HEIGHT"));
		member.setWeight(rset.getString("MB_WEIGHT"));
		member.setFootSize(rset.getString("MB_FOOTSIZE"));
		member.setMemberDate(rset.getTimestamp("MB_DATE"));
		member.setUpdateDate(rset.getTimestamp("UPDATE_DATE"));
		member.setMemberYn(rset.getString("MB_YN"));
		return member;
	}

	public int updateMember(Connection conn, Member member) {
		// TODO Auto-generated method stub
		String query = "UPDATE MB_TBL SET MB_PASSWORD = ?, MB_CHOICE1 = ?, MB_TEL = ?, MB_NAME = ?, MB_EMAIL = ?, MB_CHOICE2 = ?, MB_GENDER = ?, MB_HEIGHT = ?, MB_WEIGHT = ?, MB_FOOTSIZE = ?, UPDATE_DATE = SYSDATE WHERE MB_USERID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getChoice1());
			pstmt.setString(3, member.getTel());
			pstmt.setString(4, member.getUserName());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getChoice2());
			pstmt.setString(7, member.getGender());
			pstmt.setString(8, member.getHeight());
			pstmt.setString(9, member.getWeight());
			pstmt.setString(10, member.getFootSize());
			pstmt.setString(11, member.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
	
}
