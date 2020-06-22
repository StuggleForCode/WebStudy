package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

public interface RouteService {
    PageBean findPage(int cid, int currentPage, int pageSize, String rname);

    Route finOneByRid(String rid);

    boolean isfavorite(String rid, int uid);

    void favorite(boolean flag, String rid, int uid);

    int favoriteCount(String rid);

    PageBean findFavOrderPage(int currentPage, int pageSize);
}
