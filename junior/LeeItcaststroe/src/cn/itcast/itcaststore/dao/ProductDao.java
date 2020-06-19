package cn.itcast.itcaststore.dao;

import cn.itcast.itcaststore.domain.Order;
import cn.itcast.itcaststore.domain.OrderItem;
import cn.itcast.itcaststore.domain.Product;
import cn.itcast.itcaststore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    //1.查找所有商品
    public List<Product> listAll() throws SQLException {
        String sql = "select * from products";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Product>(Product.class));
    }

    //2.根据id查找商品
    public Product findProductById(String id){
        String sql = "select * from products where id = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return runner.query(sql, new BeanHandler<Product>(Product.class), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //3.获取数据的总条数
    public int findAllCount(String category) throws  SQLException{
        String sql = "select count(*) from products";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        //判断是所有商品还是某种商品
        if(!"全部商品".equals(category)){
            sql += " where category=?";
            Long count = (Long)runner.query(sql, new ScalarHandler(),category);
            return count.intValue();
        }else{
            Long count = (Long)runner.query(sql, new ScalarHandler());
            return count.intValue();
        }
    }

    //4.多条件查询
    public List<Product> findProductByManyCondition(String id ,String name, String category, String minprice, String maxprice) throws SQLException{
        List<Object> list = new ArrayList<Object>();
        String sql = "select * from products where 1 = 1 "; //1 = 1 永为真，构建动态sql
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        if(id != null && id.trim().length()>0){
            sql += " and id = ?";
            list.add(id);
        }
        if(name != null && name.trim().length()>0){
            sql += " and name = ?";
            list.add(name);
        }
        if(category != null && category.trim().length()>0){
            sql += "  and category = ?";
            list.add(category);
        }
        if(minprice != null && maxprice != null
                && minprice.trim().length()>0 && maxprice.trim().length()>0){
            sql += " and price between ? and ?";
            list.add(minprice);
            list.add(maxprice);
        }
        Object[] params = list.toArray();
        return runner.query(sql, new BeanListHandler<>(Product.class), params);
    }

    //5.添加商品
    public void addProduct(Product p){
        String sql = "insert into products values(?,?,?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            runner.update(sql, p.getId(), p.getName(), p.getPrice(), p.getCategory(),p.getPnum(), p.getImgurl(), p.getDescription());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //6.修改商品信息
    public void editProduct(Product p){
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        List<Object> obj = new ArrayList<Object>();
        obj.add(p.getName());
        obj.add(p.getPrice());
        obj.add(p.getCategory());
        obj.add(p.getPnum());
        obj.add(p.getDescription());
        String sql = "update products set name = ?, price=?, category=?, pnum =?, description=?";
        //判断是否有图片
        if(p.getImgurl() != null && p.getImgurl().trim().length()>0){
            sql += ", imgurl=?";
            obj.add(p.getImgurl());
        }
        sql += " where id = ?";
        obj.add(p.getId());
        System.out.println(sql);
        try {
            runner.update(sql, obj.toArray());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //7.根据id删除商品
    public void deleteProduct(String id){
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from products where id = ?";
        try {
            runner.update(sql, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //8.前台搜索框，根据书名模糊查询图书数量
    public int findBookByNameAllCount(String searchfield){
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from products where name Like '%" + searchfield + "%'";
        try {
            Long count = (Long)runner.query(sql, new ScalarHandler());
            return count.intValue();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    //9.获取当前页的数据
    public List<Product> findByPage(int currentPage, int currentCount, String category){
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = null;
        Object[] obj = null;
        //是否按照分类查找
        if(!"全部商品".equals(category)){
            sql = "select * from products where category = ? limit ?, ?";
            obj = new Object[]{category, (currentPage -1 ) * currentCount, currentCount};
        }else{
            sql = "select * from products limit ?, ?";
            obj = new Object[]{(currentPage -1 ) * currentCount, currentCount};
        }

        try {
            return runner.query(sql, new BeanListHandler<>(Product.class), obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //10. 前台搜索框，根据书名模糊查询图书分页显示
    public List<Product> findBookByName(int currentPage, int currentCount, String searchfield){
        String sql = "select * from products where name like '%" + searchfield + "%' limit ?, ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
//        System.out.println(sql);
        Object[] obj = null;
        obj = new Object[]{(currentPage -1 ) * currentCount, currentCount};
        try {
            return runner.query(sql, new BeanListHandler<>(Product.class), obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //11.生成订单时，减少商品数量
    public void changeProductNum(Order order) throws SQLException {
        String sql = "update products set pnum = pnum - ? where id = ?";
        QueryRunner runner = new QueryRunner();
        List<OrderItem> items = order.getOrderItemList();
        Object[][] params = new Object[items.size()][2];
        for(int i = 0; i < params.length; i++){
            params[i][0] = items.get(i).getBuyNum();
            params[i][1] = items.get(i).getProduct().getId();
        }
        runner.batch(DataSourceUtils.getConnection(), sql ,params);
    }

    //12.删除订单时，修改商品的数量
    public void updateProductNum(Order order) throws SQLException {
        OrderItemDao orderItemDao = new OrderItemDao();
        List<OrderItem> items = orderItemDao.findOrderItemByOrder(order);
        String sql = "update products set pnum = pnum + ? where id = ?";
        QueryRunner runner = new QueryRunner();
        Object[][] params = new Object[items.size()][2];
        for(int i = 0; i < params.length; i++){
            params[i][0] = items.get(i).getBuyNum();
            params[i][1] = items.get(i).getProduct().getId();
        }
        runner.batch(DataSourceUtils.getConnection(), sql ,params);
    }

    //前台，获取本周商品热卖
    public List<Object[]> getWeekHotProduct() throws SQLException {
        String sql = "select products.id, products.name, products.imgurl, sum(buynum) totalSalSum" +
                " from orders, orderitem, products where orders.id = orderitem.order_id" +
                " and orderitem.product_id = products.id group by product_id" +
                " order by totalSalsum desc limit 0, 2";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new ArrayListHandler());
    }

    //后台 销售榜单
    public List<Object[]> salesList(String year, String month) throws SQLException {
       String sql = " SELECT  products.name, SUM(buynum) totalSalNum FROM orderitem, products, orders" +
               "        WHERE  orderitem.product_id = products.id AND orderitem.order_id = orders.id and paystate = 1" +
               "        AND YEAR(ordertime) = ? AND MONTH(ordertime) = ?" +
               "        GROUP BY products.name" +
               "        ORDER BY totalSalNum DESC";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql ,new ArrayListHandler(), year, month);
    }

    public static void main(String[] args) throws SQLException{
        ProductDao dao = new ProductDao();

//        try {
//            List<Product> products = dao.listAll();
//            System.out.println(products.size());
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

//        Product p = dao.findProductById("3a0196b2-71c1-4d4d-a4e8-d1f875096f00");
//        System.out.println(p.getName());

//        long count = dao.findAllCount("计算机");
//        System.out.println(count);

//        List list = dao.findProductByManyCondition(null, "杜拉拉升职记", null, "50", "100");
//        System.out.println(list.size());

//        Product p = new Product();
//        p.setId("sdljfsdjfkdsjksjdfk");
//        p.setName("java实验");
//        dao.addProduct(p);
//        p.setPrice(68);
//        dao.editProduct(p);

//        dao.deleteProduct("sdljfsdjfkdsjksjdfk");

//        int count = dao.findBookByNameAllCount("Java");
//        System.out.println(count);

//        List<Product> list = dao.findByPage(2, 5, "全部商品");
//        for (int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i).getName());
//        }

//        List<Product> list = dao.findBookByName(1, 4, "e");
//        for (int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i).getName());
//        }

//        dao.changeProductNum(order);

        /*Order order = new Order();
        Product product = new Product();
        product.setId("79bbe618-d2f8-4081-b35a-62ebbe938b64");
        OrderItem item = new OrderItem();
        item.setBuyNum(2);
        item.setProduct(product);
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(item);
        order.setOrderItemList(orderItems);
        dao.changeProductNum(order);*/

//        Product product = new Product();
//        product.setId("79bbe618-d2f8-4081-b35a-62ebbe938b64");
//        OrderItem item = new OrderItem();
//        item.setBuyNum(2);
//        item.setProduct(product);
//        List<OrderItem> orderItems = new ArrayList<OrderItem>();
//        orderItems.add(item);
//        dao.updateProductNum();


        List<Object[]> list = dao.salesList("2020", "6");
        for(Object[] obArray:list){
            for(Object ob:obArray){
                System.out.println(ob.toString());
            }
        }
    }
}
