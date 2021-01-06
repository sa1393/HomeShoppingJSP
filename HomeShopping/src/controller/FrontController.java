package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(name = "front", urlPatterns = { "*.do" })
public class FrontController extends HttpServlet {
	
	String charset;
	HashMap<String, Controller> list = null;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		list.put("/HomeMemberInsertController.do", new HomeMemberInsertController());
		list.put("/HomeMemberListController.do", new HomeMemberListController());
		list.put("/HomeMemberUpdateController.do", new HomeMemberUpdateController());
		list.put("/MemberMoneyListController.do", new MemberMoneyListController());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(charset);
		
		String url = request.getRequestURI(); //ex) /dev/memberSearch.do
		String contextPath = request.getContextPath(); //ex) /dev
		String path = url.substring(contextPath.length()); //ex) memberSearch.do
		
		System.out.println(path);
		Controller subController = list.get(path);
		subController.excute(request, response);
	}

}
