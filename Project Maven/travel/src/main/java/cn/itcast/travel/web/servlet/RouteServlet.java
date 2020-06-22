package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.service.impl.CategoryServiceImpl;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    RouteService routeService = new RouteServiceImpl();

    public void findPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String rname = request.getParameter("rname");
        //获取cid
        String cidStr = request.getParameter("cid");
        //获取currentPage
        String currentPageStr = request.getParameter("currentPage");

        //把它们转成int类型
        int cid = 0;
        if (cidStr != null && !"".equalsIgnoreCase(cidStr) && !"null".equalsIgnoreCase(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }

        int currentPage = 0;
        if (currentPageStr != null && !"".equalsIgnoreCase(currentPageStr) && !"null".equalsIgnoreCase(currentPageStr)) {
            currentPage = Integer.parseInt(currentPageStr);
        }

        //默认的pageSize
        int pageSize = 5;

        PageBean pb = routeService.findPage(cid, currentPage, pageSize, rname);

        System.out.println(pb);
        writeValue(response, pb);

    }

    public void findOneByRid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String rid = request.getParameter("rid");
        Route route = routeService.finOneByRid(rid);

        System.out.println(route);
        writeValue(response,route);
    }

    public void isfavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("user");
        boolean flag = routeService.isfavorite(rid,user.getUid());
        writeValue(response,flag);
    }

    public void favorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String flagStr = request.getParameter("flag");
        boolean flag = Boolean.parseBoolean(flagStr);

        User user = (User) request.getSession().getAttribute("user");

        String rid = request.getParameter("rid");

        routeService.favorite(flag,rid,user.getUid());
    }

    public void favoriteCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String rid = request.getParameter("rid");

        int count = routeService.favoriteCount(rid);

        writeValue(response,count);
    }

    public void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String currentPageStr = request.getParameter("currentPage");
        int currentPage = Integer.parseInt(currentPageStr);




        int pageSize = 8;

        PageBean pb = routeService.findFavOrderPage(currentPage,pageSize);
        System.out.println(pb);
        writeValue(response,pb);
    }

}
