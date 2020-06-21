package cn.itcast.jdbc.web.servlet;

import cn.itcast.jdbc.domain.User;
import cn.itcast.jdbc.service.UserService;
import cn.itcast.jdbc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/findUserByManyConditionServlet")
public class FindUserByManyConditionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取表单数据
        String uId = request.getParameter("uId");//商品id
        String uName = request.getParameter("uName");//商品名称
        String BankId = request.getParameter("BankId");//商品种类
        //2.创建ProductService对象
        UserService service = new UserServiceImpl();
        //3.调用service对象用户多条件查询的方法
        List<User> users = null;
        try {
            users = service.findUserByManyCondition(uId, BankId, uName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //4.将查询结果放入request域中
        request.setAttribute("users", users);
        //5.重定向到商品管理首页list.jsp
        request.getRequestDispatcher("/admin/Users/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
