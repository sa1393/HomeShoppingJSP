package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberMoneyVO;
import vo.MemberVO;

public class MemberMoneyListController implements Controller{
	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws SecurityException, IOException {
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		String path = null;
		path = "/view/memberMoneyList.jsp";
		
		//db연동
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberMoneyVO> list = dao.SearchMoney();
		System.out.println(list);
		req.setAttribute("moneylist", list);
		
		try {
			req.getRequestDispatcher(path).forward(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
