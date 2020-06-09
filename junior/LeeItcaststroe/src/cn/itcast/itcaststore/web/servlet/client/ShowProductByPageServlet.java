package cn.itcast.itcaststore.web.servlet.client;

import cn.itcast.itcaststore.domain.PageBean;
import cn.itcast.itcaststore.domain.Product;
import cn.itcast.itcaststore.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showProductByPageServlet")
public class ShowProductByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置当前页，默认为1
        int currentPage = 1;
        String _currentPage = request.getParameter("currentPage");
        if(_currentPage != null){
            currentPage = Integer.parseInt(_currentPage);
        }
        //2.设置每页显示条数，默认为4
        int currentCount = 4;
        String _currentCount = request.getParameter("currentCount");
        if(_currentCount != null){
            currentCount = Integer.parseInt(_currentCount);
        }
        //3.获得查找的分类
        String category = "全部商品";
        String _category = request.getParameter("category");
        if(_category != null){
            //category = new String(_category.getBytes("ISO-8859-1"), "UTF-8");
            category = _category;
        }
        //category = "全部商品";
        System.out.println(category);
        //4.调用service，获取当前页分页的bean数据
        ProductService service = new ProductService();
        PageBean bean = service.findProductByPage(currentPage, currentCount, category);
//        System.out.println("wwwww");
//        System.out.println(category);
//        List<Product> ps = bean.getPs();
//        for(int i = 0; i <ps.size(); i++){
//            System.out.println(ps.get(i).getName());
//        }
        //5.保存数据，跳转到商品列表也页面
        request.setAttribute("bean", bean);
        request.getRequestDispatcher("/client/product_list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
