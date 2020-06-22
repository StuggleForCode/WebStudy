package cn.itcast.travel.web.servlet;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.SellerDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    RouteDao routeDao = new RouteDaoImpl();
    @Override
    public PageBean findPage(int cid, int currentPage, int pageSize, String rname) {
        PageBean pb = new PageBean();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);

        int totalCount = routeDao.totalCount(cid,rname);
        pb.setTotalCount(totalCount);//总条数
        //计算总页数  500  5 = 100    503   5  = 101
        int totalPage = (totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
        pb.setTotalPage(totalPage);

        //起始的索引位置
        //第1磁数据：数据库里要查询的是第0每次数据，第一条数据的起始索引是0   查5条   0，1，2，3，4
        //第2页数据：数据库里要查询的是第一条数据，第一条数据的起始索引是5    查5条   5，6，7，8，9
        //第3页数据：数据库里要查询的是第二条数据，第一条数据的起始索引是10    查5条   10，11，12，13，14

        int start = (currentPage-1)*pageSize;
        pb.setList(routeDao.findByCid(cid,start,pageSize,rname));

        return pb;
    }

    SellerDao sellerDao = new SellerDaoImpl();

    @Override
    public Route finOneByRid(String rid) {
        //先用rid查找一个线路的对象
        Route route = routeDao.findOneByRid(rid);
        //但是这个route对象少了一些关于这个路线的图片和商家的信息
        //这里查线路的是线路的图片
        List<RouteImg> list = routeDao.findRouteImgByRid(rid);
        //这里查找的是线路的商家
        Seller seller = sellerDao.findOneBySid(route.getSid());
        //把图片和商家放到route对象里
        route.setRouteImgList(list);
        route.setSeller(seller);
        //返回线路对象
        return route;
    }

    @Override
    public boolean isfavorite(String rid, int uid) {
        return routeDao.isfavorite(rid,uid);
    }

    @Override
    public void favorite(boolean flag, String rid, int uid) {
        routeDao.favorite(flag,rid,uid);
    }

    @Override
    public int favoriteCount(String rid) {
        return routeDao.favoriteCount(rid);
    }

    @Override
    public PageBean findFavOrderPage(int currentPage, int pageSize) {
        PageBean pb = new PageBean();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);

        int totalCount = routeDao.findFavOrderPageCount(currentPage,pageSize);
        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1);
        pb.setList(routeDao.findFavorderPage(currentPage,pageSize));

        return pb;
    }
}
