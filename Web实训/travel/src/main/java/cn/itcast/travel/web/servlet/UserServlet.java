package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
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

            System.out.println(user);

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
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        //这个是我们后台CheckCodeServlet生成的
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        ResultInfo info = new ResultInfo();
      //  System.out.println("login_check: " + check);
        //System.out.println("login_checkcode_server :" + checkcode_server);
        if (check.equalsIgnoreCase(checkcode_server)) {
            //获取登录页面请求时的参数
            Map<String, String[]> map = request.getParameterMap();
            User user = new User();
            BeanUtils.populate(user,map);

            //返回给我们一个完整的用户对象
            User loginUser = userService.login(user);

           // System.out.println("login_loginUser: "+loginUser);


            if(loginUser!=null) {
                session.setAttribute("user", loginUser);
                String auto_login = request.getParameter("auto_loginCheckbox");
                System.out.println("auto_login：" +  auto_login);
                if("on".equalsIgnoreCase(auto_login)){
                    Cookie cook1 = new Cookie("HeiMaUsername", URLEncoder.encode(loginUser.getUsername(),"utf-8"));
                    Cookie cook2 = new Cookie("HeiMaPassword", URLEncoder.encode(loginUser.getPassword(),"utf-8"));
                    cook1.setMaxAge(60*60*24);
                    cook2.setMaxAge(60*60*24);
                    cook1.setPath("/");
                    cook2.setPath("/");
                    response.addCookie(cook1);
                    response.addCookie(cook2);
                }
                info.setFlag(true);
            }else{
                info.setFlag(false);
                info.setErrorMsg("用户名或密码错误");
            }

        }else{
            info.setFlag(false);
            info.setErrorMsg("验证码输入错误！");
        }
        writeValue(response,info);
    }

    public void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //获取登录页面请求时的参数
        Object user = request.getSession().getAttribute("user");
        //System.out.println("getUser： "+ user);
        writeValue(response,user);
    }

    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //获取登录页面请求时的参数
        request.getSession().removeAttribute("user");
        Cookie killHeiMaUsername = new Cookie("HeiMaUsername", null);
        Cookie killHeiMaPassword = new Cookie("HeiMaPassword", null);
        killHeiMaUsername.setMaxAge(0);
        killHeiMaUsername.setPath("/");
        response.addCookie(killHeiMaUsername);
        killHeiMaPassword.setMaxAge(0);
        killHeiMaPassword.setPath("/");
        response.addCookie(killHeiMaPassword);
    }

    public void autoLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //获取登录页面请求时的参数
        Cookie[] cookies = request.getCookies();
        String username = "";
        String password = "";
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if(name.equalsIgnoreCase("HeiMaUsername")){
                username = URLDecoder.decode(cookie.getValue(),"utf-8");
            }
            if(name.equalsIgnoreCase("HeiMaPassword")){
                password = URLDecoder.decode(cookie.getValue(),"utf-8");
            }
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
       // System.out.println(user);
        if(user.getUsername() == "" || user.getUsername() == null){
            writeValue(response,null);
        }else{
            User loginUser = userService.login(user);
//        System.out.println(loginUser);
            HttpSession session = request.getSession();
            session.setAttribute("user", loginUser);
           // System.out.println("auto_login_loginUser:" + loginUser);
            writeValue(response,loginUser);
        }
    }

    public void myFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {

        System.out.println("myFavorite: 到我了");

        String currentPageStr = request.getParameter("currentPage");
        int currentPage = Integer.parseInt(currentPageStr);
        String uidStr = request.getParameter("uid");
        int uid = Integer.parseInt(uidStr);
        int pageSize = 12;
        PageBean pb = userService.findUserFavPage(uid, currentPage, pageSize);
        System.out.println("myFiavorite_pb: " + pb);
        writeValue(response,pb);
    }

}
