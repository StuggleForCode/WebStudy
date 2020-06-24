package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.CategoryServiceImpl;
import cn.itcast.travel.service.impl.UserServiceImpl;
import cn.itcast.travel.util.JedisUtil;
import cn.itcast.travel.util.UuidUtil;
import org.apache.commons.beanutils.BeanUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet("/category/*")
public class CategotyServlet extends BaseServlet {
    CategoryService categoryService = new CategoryServiceImpl();

    public void findCategorys(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {

//        System.out.println("调用 findCategorys");

        List<Category> list = new ArrayList<>();
        //首先从redis里查询，看是能查到数据，如果能查到，就不从数据库里查询了
        try {
            Jedis jedis = JedisUtil.getJedis();
            //查询键为categorys
            //范围从索引为0开始，到最后，-1代表到最后
            Set<Tuple> categorySet = jedis.zrangeWithScores("categorys",0,-1);
            for (Tuple tuple : categorySet) {
                double score = tuple.getScore();//cid
                String element = tuple.getElement();//cname
                Category category = new Category();
                category.setCid((int)score);
                category.setCname(element);
                list.add(category);

            }


        } catch (Exception e) {

        }
        if(list.size()<=0) {
            try {
                System.out.println("从数据库中查询");
                    list = categoryService.findAll();
                    Jedis jedis = JedisUtil.getJedis();
                    for (int i = 0; i < list.size(); i++) {
                        Category category = list.get(i);
                        //存储的是键值对的形式，一个键，对应很多个值
                        //"categorys"：键
                        //category.getCid()：权值，访问的时候，优先访问到
                        //权值就是索引，一个编号，编号越小，访问的时候越优先
                        //category.getCname(),是我们真正要存储到reids里的值
                        jedis.zadd("categorys", category.getCid(), category.getCname());

                }
            } catch (Exception e) {

            }
        }else{
            System.out.println("从redis中查询");
        }
        writeValue(response,list);

    }

}
