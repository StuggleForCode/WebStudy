package cn.itcast.itcaststore.web.servlet.client;

import cn.itcast.itcaststore.exception.ActiveUserException;
import cn.itcast.itcaststore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获得激活码
        String activeCode = request.getParameter("activeCode");
        //2.调用service激活用户操作
        UserService service = new UserService();
        try {
            service.activeUser(activeCode);
        } catch (ActiveUserException e) {
            e.printStackTrace();
        }
        //3.激活成功，跳转成功页面
        response.sendRedirect(request.getContextPath() + "/client/activesuccess.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
