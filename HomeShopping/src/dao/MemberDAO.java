package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCUtil;
import vo.MemberMoneyVO;
import vo.MemberVO;

public class MemberDAO {
	public MemberVO searchMemberOne(int custno) {
		MemberVO vo = new MemberVO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("select * from member_tbl_02 where custno = ?");
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setAddress(rs.getString("address"));
				vo.setCity(rs.getString("city"));
				vo.setCustname(rs.getString("custname"));
				vo.setCustno(rs.getInt("custno"));
				vo.setGrade(rs.getString("grade"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	
	public ArrayList<MemberMoneyVO> SearchMoney(){
		ArrayList<MemberMoneyVO> list = new ArrayList<MemberMoneyVO>();
		MemberMoneyVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement("select me.custno, custname, grade, sum(price) price from member_tbl_02 me, money_tbl_02 mo where me.custno = mo.custno group by(me.custno, custname, grade)");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new MemberMoneyVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				System.out.println(rs.getString("grade"));
				vo.setGrade(rs.getString("grade"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public ArrayList<MemberVO> SearchMember(){
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("select * from member_tbl_02");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setAddress(rs.getString("address"));
				vo.setCity(rs.getString("city"));
				vo.setCustname(rs.getString("custname"));
				vo.setCustno(rs.getInt("custno"));
				vo.setGrade(rs.getString("grade"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setPhone(rs.getString("phone"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int insertMember(MemberVO vo) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		PreparedStatement pstmt = null;
		String sql = "insert into member_tbl_02(custno, custname, phone, address, joindate, grade, city) values(?,?,?,?,?,?,?)";
		int n = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getCustno());
			pstmt.setString(2, vo.getCustname());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getAddress());
			pstmt.setDate(5, vo.getJoindate());
			pstmt.setString(6, vo.getGrade());
			pstmt.setString(7, vo.getCity());
			
			n = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return n;
	}
	
	public int UpdateData(MemberVO vo) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		PreparedStatement pstmt = null;
		String sql = "update member_tbl_02 set custname=?, phone=?, address=?, joindate=?, grade=?, city=? where custno=?";
		int n = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getCustname());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getAddress());
			pstmt.setDate(4, vo.getJoindate());
			pstmt.setString(5, vo.getGrade());
			pstmt.setString(6, vo.getCity());
			pstmt.setInt(7, vo.getCustno());
			
			n = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);

		}
		return n;
	}
	
	public int maxMemberId() {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("select max(custno) from member_tbl_02");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				n = rs.getInt("max(custno)") + 1;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return n;
	}
	
	
}