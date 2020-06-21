package cn.itcast.jdbc.web.servlet;

import cn.itcast.jdbc.Dao.UsersDao;
import cn.itcast.jdbc.domain.User;
import cn.itcast.jdbc.service.UserService;
import cn.itcast.jdbc.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setuName(request.getParameter("uName"));

        System.out.println(request.getParameter("uName"));

        user.setuPassword(request.getParameter("uPassword"));
        user.setuBirthday(request.getParameter("uBirthday"));
        user.setuAddress(request.getParameter("uAddress"));
        user.setuBankId(request.getParameter("uBankId"));
        System.out.println(user.toString());
        UserService service = new UserServiceImpl();
        try {
            service.insertUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher(request.getContextPath() + "/listUserServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
