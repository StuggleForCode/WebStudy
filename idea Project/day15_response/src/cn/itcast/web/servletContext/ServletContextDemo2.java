package cn.itcast.web.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 		1. 通过request对象获取
         * 			request.getServletContext();
         * 		2. 通过HttpServlet获取
         * 			this.getServletContext();
         */

        //2.通过HttpServlet获取
        ServletContext context = this.getServletContext();

        //3.定义文件名称
        String filename = "a.jpeg";

        //4.获取MIME类型
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
