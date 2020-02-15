package LIHAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LIHAOServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决中文乱码
		response.setContentType("text/html;charset=utf-8");
		//请求解决乱码
		request.setCharacterEncoding("utf-8");
		//响应解决乱码
		response.setCharacterEncoding("utf-8");

		String lhname = request.getParameter("lhname");
		String lhemail = request.getParameter("lhemail");
		String lhage = request.getParameter("lhage");
		String lhtime = request.getParameter("lhtime");
		String[] lhOs = request.getParameterValues("lhOs");
		String[] lhLanguage = request.getParameterValues("lhLanguage");
		String lhAdvice = request.getParameter("lhAdvice");
		
		request.getSession().setAttribute("lhname",lhname);
	    request.getSession().setAttribute("lhemail",lhemail);
	    request.getSession().setAttribute("lhage",lhage);
	    request.getSession().setAttribute("lhOs",lhOs);
	    request.getSession().setAttribute("lhtime",lhtime);
	    request.getSession().setAttribute("lhAdvice",lhAdvice);
	    request.getSession().setAttribute("lhLanguage",lhLanguage);
//	    request.getSession().setAttribute("lhAdvice",lhAdvice);
	    request.getRequestDispatcher("/LIHAO2.jsp").forward(request,response);
		 
	}
}
