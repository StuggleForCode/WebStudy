package cn.itcast.itcaststore.service;

import cn.itcast.itcaststore.dao.ProductDao;
import cn.itcast.itcaststore.domain.PageBean;
import cn.itcast.itcaststore.domain.Product;
import cn.itcast.itcaststore.exception.FindProductByIdException;

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

    //根据ID查找商品
    public Product findProductById(String id) throws FindProductByIdException {
        try {
            return dao.findProductById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FindProductByIdException("根据ID查找商品失败！");
        }
    }

    //前台，用户搜索框根据书名模糊查找相应图书
    public PageBean findBookByName(int currentPage, int currentCount, String searchfield){
        PageBean bean = new PageBean();
        //1.封装每页显示的数据条数
        bean.setCurrentCount(currentCount);
        //2.封装当前页码
        bean.setCurrentPage(currentPage);
        bean.setSearchfiled(searchfield);//封装查询的图书名
        //3.获取总条数
        try {
            int totalCount = dao.findBookByNameAllCount(searchfield);
            bean.setTotalCount(totalCount);
            //4.获取总页数
            int totalPage = (int) Math.ceil(totalCount*1.0/currentCount);
            bean.setTotalPage(totalPage);
            //5.查找满足条件的图书
            List<Product> products = dao.findBookByName(currentPage,currentCount,searchfield);
            bean.setPs(products);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("前台搜索框根据书名查询失败！");
        }
        return bean;
    }

    //前台，获得本周热销商品
    public List<Object[]> getWeekHotProduct(){
        try {
            return dao.getWeekHotProduct();
        } catch (SQLException throwables) {
            throw new RuntimeException("前台获取本周热销商品失败");
        }
    }

    //后台，查询所有商品信息
    public List<Product> listAll(){
        try {
            return dao.listAll();
        } catch (SQLException throwables) {
//            throw new ListProductExcepion("查询商品异常");
        }
        return null;
    }

    //后台多条件查询
    public List<Product> findProductByManyCondition(String id, String name, String category, String minPrice, String maxPrice){
        List<Product> ps = null;
        try {
            ps = dao.findProductByManyCondition(id, name ,category,minPrice, maxPrice);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }

    //后台商品增加
    public void addProduct(Product product){
        try {
            dao.addProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //后台商品编辑
    public void editProduct(Product product){
        try {
            dao.editProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //后台商品删除
    public void delProduct(String id){
        try {
            dao.deleteProduct(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //下载销售榜单
    public List<Object[]> download(String year, String month){
        List<Object[]> salesList = null;
        try {
            salesList = dao.salesList(year, month);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  salesList;
    }


    public static void main(String[] args) {
        ProductService service = new ProductService();
//        PageBean bean = service.findProductByPage(1, 4, "少儿");
//        List<Product> ps = bean.getPs();
//        for(int i = 0; i <ps.size(); i++){
//            System.out.println(ps.get(i).getName());
//        }

//        PageBean pageBean = service.findBookByName(1, 2, "java");
//        List<Product> ps = pageBean.getPs();
//        for (Product p:ps){
//            System.out.println(p.getName());
//        }

//        List<Object[]> list = service.getWeekHotProduct();
//        for(Object[] obArray:list){
//            for(Object ob:obArray){
//                System.out.println(ob.toString());
//            }
//        }

//        List<Product> products = service.listAll();
//        for (Product product:products){
//            System.out.println(product.getName());
//        }
//
//        List<Product> products = service.findProductByManyCondition(null, null, null, "50", "100");
//        for (Product product:products){
//            System.out.println(product.getName());
//        }

//        Product p = new Product();
//        p.setId("123456");
//        p.setName("Java核心技术修改");
//        p.setDescription("Java核心技术");
//        service.editProduct(p);
//        service.delProduct("123456");

        List<Object[]> list = service.download("2020", "6");
        for(Object[] obArray:list){
            for(Object ob:obArray){
                System.out.println(ob.toString());
            }
        }

    }

}
