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

@WebServlet("/editUserServlet")
public class EditUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        request.getParameter("uid");
        System.out.println("jjkkkkkkkkkkkkkkkkkk");
        System.out.println(Integer.valueOf(request.getParameter("uId")) + "jjjj");
        user.setuId(Integer.valueOf(request.getParameter("uId")));
        user.setuName(request.getParameter("uName"));
        System.out.println(request.getParameter("uName"));
        user.setuPassword(request.getParameter("uPassword"));
        user.setuBirthday(request.getParameter("uBirthday"));
        user.setuAddress(request.getParameter("uAddress"));
        user.setuBankId(request.getParameter("uBankId"));
        System.out.println(user.toString());
        UserService service = new UserServiceImpl();
        service.update(user);
        request.getRequestDispatcher(request.getContextPath() + "/listUserServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
