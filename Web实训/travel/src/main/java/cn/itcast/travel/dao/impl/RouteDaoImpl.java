package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.FavoriteOrder;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int totalCount(int cid, String rname) {
        String sql = "select count(*) from tab_route where 1=1 ";
        List list = new ArrayList();
        if(cid!=0){
            sql += " and cid=?";
            list.add(cid);
        }

        if(rname!=null&&!"null".equalsIgnoreCase(rname)&&!"".equalsIgnoreCase(rname)){
            sql+= " and rname like ?";
            list.add("%"+rname+"%");
        }

        return jt.queryForObject(sql,
                Integer.class,list.toArray());
    }

    @Override
    public List<Route> findByCid(int cid, int start, int pageSize, String rname) {
        //limit ?,?:
        //第1个问号：开始的索引
        //第2个问题：查询的条数
        String sql = "select * from tab_route where 1=1 ";

        List list = new ArrayList();
        if(cid!=0){
            sql += " and cid=?";
            list.add(cid);
        }

        if(rname!=null&&!"null".equalsIgnoreCase(rname)&&!"".equalsIgnoreCase(rname)){
            sql+= " and rname like ?";
            list.add("%"+rname+"%");
        }

        sql+= " limit ?,?";
        list.add(start);
        list.add(pageSize);
        return jt.query(sql,
                new BeanPropertyRowMapper<Route>(Route.class),list.toArray());
    }

    @Override
    public Route findOneByRid(String rid) {
        return jt.queryForObject("select * from tab_route where rid = ?",
                new BeanPropertyRowMapper<Route>(Route.class),rid);

    }

    @Override
    public List<RouteImg> findRouteImgByRid(String rid) {
        return jt.query("select * from tab_route_img where  rid = ? ",
                new BeanPropertyRowMapper<RouteImg>(RouteImg.class),rid);
    }

    @Override
    public boolean isfavorite(String rid, int uid) {
        try {
            Favorite favorite = jt.queryForObject("select * from tab_favorite where rid=? and uid=?",
                    new BeanPropertyRowMapper<Favorite>(Favorite.class), rid, uid);
            if(favorite!=null){
                return true;
            }
        } catch (DataAccessException e) {

        }
        return false;
    }

    @Override
    public void favorite(boolean flag, String rid, int uid) {
        if(flag){
            //收藏线路
            jt.update("insert into tab_favorite  values(?,?,?) ",rid,new Date(),uid);
        }else{
            //取消收藏线路
            jt.update("delete from tab_favorite where uid=? and rid=? ",uid,rid);
        }
    }

    @Override
    public int favoriteCount(String rid) {
        String sql = "select count(*) from tab_favorite where rid=? ";
        return jt.queryForObject(sql,Integer.class,rid);
    }

    @Override
    public int findFavOrderPageCount(int currentPage, int pageSize) {
        // return jt.queryForObject("select ")
        //代码未完成
        return jt.queryForObject("SELECT COUNT(*) FROM tab_favorite",Integer.class);
    }

    @Override
    public List<Route> findFavorderPage(int currentPage, int pageSize) {

        int start = (currentPage-1)*pageSize;
        String sql = "SELECT *,oo.orr AS COUNT  FROM tab_route,(SELECT COUNT(*) AS orr,rid FROM tab_favorite GROUP BY rid ORDER BY COUNT(*) DESC) oo WHERE tab_route.rid = oo.rid ORDER BY oo.orr DESC LIMIT ?,?";
        return jt.query(sql,new BeanPropertyRowMapper<Route>(Route.class),start,pageSize);

    }
}
