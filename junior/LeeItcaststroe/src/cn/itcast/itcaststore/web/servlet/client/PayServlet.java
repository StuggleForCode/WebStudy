package cn.itcast.itcaststore.web.servlet.client;

/**
 * 模拟支付
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/payServlet")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.将要提交的数据得到
        String orderid = request.getParameter("orderid");
        String money = request.getParameter("money");
        //2.获得支付必须的基本数据
        String bank = request.getParameter("bank");
        request.setAttribute("bank", bank);
        request.setAttribute("orderid", orderid);
        request.setAttribute("money", money);
        //3.转向支付确认页面
        request.getRequestDispatcher("/client/confirm.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
