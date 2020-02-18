package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 		1. 需求：
         * 			1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
         * 			2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
         *
         * 		2. 分析：
         * 			1. 可以采用Cookie来完成
         * 			2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
         * 				1. 有：不是第一次访问
         * 					1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
         * 					2. 写回Cookie：lastTime=2018年6月10日11:50:01
         * 				2. 没有：是第一次访问
         * 					1. 响应数据：您好，欢迎您首次访问
         * 					2. 写回Cookie：lastTime=2018年6月10日11:50:01
         */
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean ok = false;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        String str_date = sdf.format(date);
        System.out.println("编码器前："+ str_date);
        str_date = URLEncoder.encode(str_date,"utf-8");
        System.out.println("编码后：" + str_date);
        if(cookies != null){
            for (Cookie c : cookies){
                System.out.println(c.getName());
                if("lastTime".equals(c.getName())){
                        System.out.println("fark");
                        ok = true;
                        String value = c.getValue();
                        System.out.println("解码前：" + value);
                        value = URLDecoder.decode(value,"utf-8");
                        System.out.println("解码后：" + value);
                        System.out.println("欢迎回来，你上一次访问的时间为：" + value);
                        response.getWriter().write("欢迎回来，你上一次访问的时间为：" +
                                value);
                        c.setValue(str_date);
                        //设置cookie的存活时间
                        c.setMaxAge(60 * 60 * 24 * 30);
                        response.addCookie(c);
                        break;
                }
            }
        }
        if(!ok){
            response.getWriter().write("你好，欢迎首次访问");
            System.out.println("你好，欢迎首次访问");
            Cookie cookie = new Cookie("lastTime", str_date);
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
