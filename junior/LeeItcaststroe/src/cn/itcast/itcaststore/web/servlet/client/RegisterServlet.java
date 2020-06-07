package cn.itcast.itcaststore.web.servlet.client;

import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.service.UserService;
import cn.itcast.itcaststore.utils.ActiveCodeUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.将注册的表单提交的数据封装到javaBean
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //2.调用service完成注册操作
        ActiveCodeUtils activeCodeUtils = new ActiveCodeUtils();
        user.setActiveCode(activeCodeUtils.createActiveCode());
        UserService service = new UserService();
        service.register(user);
        //3.注册成功，跳转成功页面
        response.sendRedirect(request.getContextPath()+"/client/registersuccess.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
