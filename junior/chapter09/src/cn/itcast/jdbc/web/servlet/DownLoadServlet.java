package cn.itcast.jdbc.web.servlet;

import cn.itcast.itcaststore.service.ProductService;
import cn.itcast.jdbc.Dao.Impl.UsersDaoImpl;
import cn.itcast.jdbc.domain.User;
import cn.itcast.jdbc.service.UserService;
import cn.itcast.jdbc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/downLoadServlet")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       UserService service = new UserServiceImpl();
        List<User> users = null;
        try {
            users = service.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String fileName = "所有用户信息.csv";
        response.setContentType(this.getServletContext().getMimeType(fileName));
        response.setHeader("Content-Disposition", "attachment;fileName="
                + new String(fileName.getBytes("GBK"),"iso8859-1"));
        response.setCharacterEncoding("GBK");
        PrintWriter out = response.getWriter();
        for(int i = 0; i < users.size(); i++){
            System.out.println(users.get(i).getuId() + users.get(i).getuPassword());
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
