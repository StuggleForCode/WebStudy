package cn.itcast.jdbc.web.servlet;

import cn.itcast.jdbc.domain.User;
import cn.itcast.jdbc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/listUserServlet")
public class ListUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建service层对象
        UserServiceImpl service = new UserServiceImpl();
        //2.调用service用于查询所有用户的方法
        List<User> users = null;
        try {
            users = service.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //3.将查出的用户放入request
        request.setAttribute("users", users);;
        //4。重定向list.jsp页面
        request.getRequestDispatcher("/admin/Users/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
