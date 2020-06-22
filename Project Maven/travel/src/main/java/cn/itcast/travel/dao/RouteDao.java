package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;

import java.util.List;

public interface RouteDao {
    int totalCount(int cid, String rname);

    List<Route> findByCid(int cid, int start, int pageSize, String rname);

    Route findOneByRid(String rid);

    List<RouteImg> findRouteImgByRid(String rid);

    boolean isfavorite(String rid, int uid);

    void favorite(boolean flag, String rid, int uid);

    int favoriteCount(String rid);

    int findFavOrderPageCount(int currentPage, int pageSize);

    List<Route> findFavorderPage(int currentPage, int pageSize);
}
