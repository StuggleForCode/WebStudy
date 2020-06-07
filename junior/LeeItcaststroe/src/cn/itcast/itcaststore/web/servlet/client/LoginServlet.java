package cn.itcast.itcaststore.web.servlet.client;

import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.service.UserService;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获得用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.调用service完成登陆操作
        UserService service = new UserService();
        //3.登陆成功，讲用户存入session
        try {
            User user = service.login(username, password);
            //4.判断是管理员还是普通用胡，分别进入管理员home页面和我的账户myAccount页面
            String role = user.getRole();
            if("超级用户".equals(role)){
                response.sendRedirect(request.getContextPath() + "/admin/login/home.jsp");
                return;
            }else {
                response.sendRedirect(request.getContextPath() + "/client/myAccount.jsp");
                return;
            }
        } catch (LoginException e) {
            e.printStackTrace();
            request.setAttribute("register_msg", e.getMessage());
            request.getRequestDispatcher("client/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
