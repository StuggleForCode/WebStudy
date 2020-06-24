package cn.itcast.travel.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.awt.SystemColor.info;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        //反射
        //uri = /user/regist;
        String methodName = uri.substring(uri.lastIndexOf("/") + 1);
        System.out.println(methodName);

        try {
            //获取方法：regist
            //this.getClass():获取内存中的class字符码文件，
            //这个字节码文件中就包含了regist方法
            //getMethod()可以获取class字节码文件中的方法
            //参数是方法的名字，和方法的参数类型
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            //执行方法
            //快捷键ctrl + alt + T
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    public void writeValue(HttpServletResponse response,Object obj) throws IOException {
        ObjectMapper om = new ObjectMapper();
        response.setContentType("application/json;charset=utf8");
        om.writeValue(response.getOutputStream(), obj);
    }
}
