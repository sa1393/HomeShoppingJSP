package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

public class HomeMemberInsertController implements Controller{
	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws SecurityException, IOException {
		int custno = Integer.parseInt(req.getParameter("custno"));
		String custname = req.getParameter("custname");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		Date joindate = Date.valueOf(req.getParameter("joindate"));
		String grade = req.getParameter("grade");
		String city = req.getParameter("city");
		
		MemberVO member = new MemberVO();
		member.setAddress(address);
		member.setCity(city);
		member.setCustname(custname);
		member.setCustno(custno);
		member.setGrade(grade);
		member.setJoindate(joindate);
		member.setPhone(phone);
		
		MemberDAO dao = new MemberDAO();
		int n = dao.insertMember(member);
		if(n > 0) {
			try {
				req.getRequestDispatcher("/HomeMemberListController.do").forward(req, res);
			} catch (ServletException e) {
				e.printStackTrace();
			}
			
		}
	}
}
