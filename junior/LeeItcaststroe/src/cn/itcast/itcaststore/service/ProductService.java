package cn.itcast.itcaststore.service;

import cn.itcast.itcaststore.dao.ProductDao;
import cn.itcast.itcaststore.domain.PageBean;
import cn.itcast.itcaststore.domain.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    ProductDao dao = new ProductDao();
    //分页显示商品
    public PageBean findProductByPage(int currentPage, int currentCount, String category){
        //1.封装每页显示的条数
        PageBean bean = new PageBean();
        bean.setCurrentCount(currentCount);
        //2.设置当前页码
        bean.setCurrentPage(currentPage);
        //3.设置查找类别
        bean.setCategory(category);
        //4.查找指定页商品
        try {
            int totalCount = dao.findAllCount(category);
            bean.setTotalCount(totalCount);
            int totalPage = (int)Math.ceil(totalCount * 1.0/currentCount);
            bean.setTotalPage(totalPage);
            //获取当前页的数据
            List<Product> ps = dao.findByPage(currentPage, currentCount, category);
            bean.setPs(ps);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }


    public static void main(String[] args) {
        ProductService service = new ProductService();
        PageBean bean = service.findProductByPage(1, 4, "少儿");
        List<Product> ps = bean.getPs();
        for(int i = 0; i <ps.size(); i++){
            System.out.println(ps.get(i).getName());
        }

    }
}
