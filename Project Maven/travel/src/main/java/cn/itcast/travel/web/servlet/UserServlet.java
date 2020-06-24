package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import cn.itcast.travel.util.UuidUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //这个是我们在注册页面写入的
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        //这个是我们后台CheckCodeServlet生成的
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");

        if (check.equalsIgnoreCase(checkcode_server)) {

            Map<String, String[]> map = request.getParameterMap();
            User user = new User();
            //邮箱是否已激活
            user.setStatus("N");

            //激活邮件的标识码,必须要保证唯一
            user.setCode(UuidUtil.getUuid());

            //把map里的接收到的表单项的值，封装到user里面去
            BeanUtils.populate(user, map);

            ResultInfo info = userService.regist(user);

            //把info变成json数据
            writeValue(response, info);
        } else {
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            writeValue(response, info);
        }
    }

    public void acitve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String code = request.getParameter("code");
        boolean flag = userService.active(code);
        if(flag){
            response.sendRedirect(request.getContextPath()+"/login.html");
        }else{
            response.setContentType("text/html;charset=utf8");
            response.getWriter().write("激活失败，请重新注册");
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //获取登录页面请求时的参数
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        BeanUtils.populate(user,map);

        //返回给我们一个完整的用户对象
        User loginUser = userService.login(user);
        System.out.println(loginUser);

        ResultInfo info = new ResultInfo();
        if(loginUser!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", loginUser);

            Cookie cook1 = new Cookie("username", URLEncoder.encode(loginUser.getUsername(),"utf-8"));
            Cookie cook2 = new Cookie("password", URLEncoder.encode(loginUser.getPassword(),"utf-8"));
            cook1.setMaxAge(360*24*60);
            cook2.setMaxAge(360*24*60);
            cook1.setPath("/");
            cook2.setPath("/");
            response.addCookie(cook1);
            response.addCookie(cook2);

            info.setFlag(true);
        }else{
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
        writeValue(response,info);

    }

    public void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //获取登录页面请求时的参数
        Object user = request.getSession().getAttribute("user");
        writeValue(response,user);

    }

    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //获取登录页面请求时的参数
        request.getSession().removeAttribute("user");
    }

    public void autoLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //获取登录页面请求时的参数
        Cookie[] cookies = request.getCookies();
        String username = "";
        String password = "";
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if(name.equalsIgnoreCase("username")){
                username = URLDecoder.decode(cookie.getValue(),"utf-8");
            }
            if(name.equalsIgnoreCase("password")){
                password = URLDecoder.decode(cookie.getValue(),"utf-8");
            }
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        User loginUser = userService.login(user);


        writeValue(response,loginUser);


    }

}
