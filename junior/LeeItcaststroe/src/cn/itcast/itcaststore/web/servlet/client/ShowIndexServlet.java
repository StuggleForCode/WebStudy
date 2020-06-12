package cn.itcast.itcaststore.web.servlet.client;

/**
 * 前台页面展示的Servlet
 * 1.展示最新添加或修改的一条公告
 * 2.展示本周热卖商品
 */

import cn.itcast.itcaststore.domain.Notice;
import cn.itcast.itcaststore.service.NoticeService;
import cn.itcast.itcaststore.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showIndexServlet")
public class ShowIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.查询最近一条公告，传递/client/index.jsp页面进行展示
        NoticeService noticeService = new NoticeService();
        Notice notice = noticeService.getRecentNotice();
        request.setAttribute("n", notice);
        //2.查询本周热卖的两个商品，传递到/client.index.jsp页面进行展示
        ProductService productService = new ProductService();
        List<Object[]> list = productService.getWeekHotProduct();
        request.setAttribute("pList", list);
        //3.跳转到/client/index.jsp
        request.getRequestDispatcher("/client/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
