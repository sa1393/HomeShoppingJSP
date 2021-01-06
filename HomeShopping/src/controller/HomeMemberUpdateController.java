package controller;

import java.io.IOException;
import java.sql.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

public class HomeMemberUpdateController implements Controller{
	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws SecurityException, IOException {
		
		if(req.getMethod().equals("GET")) {
			int custno = Integer.parseInt(req.getParameter("custno"));
			MemberDAO dao = new MemberDAO();
			MemberVO vo = dao.searchMemberOne(custno);
			
			try {
				req.setAttribute("member", vo);
				req.getRequestDispatcher("/view/memberUpdate.jsp").forward(req, res);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}else if(req.getMethod().equals("POST")) {
			int custno = Integer.parseInt(req.getParameter("custno"));
			String custname = req.getParameter("custname");
			String phone = req.getParameter("name");
			String address = req.getParameter("mail");
			Date joindate = Date.valueOf(req.getParameter("joindate"));
			String grade = req.getParameter("passwd");
			String city = req.getParameter("name");
			
			MemberVO member = new MemberVO();
			member.setAddress(address);
			member.setCity(city);
			member.setCustname(custname);
			member.setCustno(custno);
			member.setGrade(grade);
			member.setJoindate(joindate);
			member.setPhone(phone);
			
			MemberDAO dao = new MemberDAO();
			int n = dao.UpdateData(member);
			
			if(n > 0) {
				try {
					req.getRequestDispatcher("/HomeMemberListController.do").forward(req, res);
				} catch (ServletException e) {
					e.printStackTrace();
				}
				
			}
			
			
		}
		
		
		


		
	}
}
