package cn.itcast.itcaststore.dao;

import cn.itcast.itcaststore.domain.Notice;
import cn.itcast.itcaststore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.management.NotCompliantMBeanException;
import java.sql.SQLException;
import java.util.List;

/**
 * 公告数据库操作类
 */
public class NoticeDao {

    //1.后台系统中，查询所有公告
    public List<Notice> getAllNotices() throws SQLException {
        String sql = "select * from notice order by n_time desc limit 0, 10";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<>(Notice.class));
    }

    //2.后台系统根据id查找公告
    public Notice findNoticeById(String n_id) throws SQLException {
        String sql = "select * from notice where n_id = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<>(Notice.class), n_id);
    }



    //3.前台系统，查询最新添加或修改的一条公告
    public Notice getRecentNotice() throws SQLException {
        String sql = "select * from notice order by n_time desc limit 0, 1";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<>(Notice.class));
    }

    //4.后台系统添加公告
    public void addNotice(Notice n) throws SQLException {
        String sql = "insert into notice(title, details, n_time) values(?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, n.getTitle(), n.getDetails(), n.getN_time());
    }

    //5.后台系统，根据id修改公告
    public void updateNotice(Notice n) throws SQLException {
        String sql = "update notice set title=?, details=?, n_time= ? where n_id=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, n.getTitle(), n.getDetails(), n.getN_time(), n.getN_id());
    }

    //6.后台系统，根据id删除公告
    public  void deleteNotice(String n_id) throws SQLException {
        String sql = "delete from notice where n_id = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, n_id);
    }


    public static void main(String[] args) throws SQLException {
        NoticeDao noticeDao = new NoticeDao();
//        List<Notice> allNotices = noticeDao.getAllNotices();
//        for(Notice n:allNotices){
//            System.out.println(n.getTitle());
//        }

//        Notice notice = noticeDao.findNoticeById("1");
//        System.out.println(notice.getTitle());

//        Notice notice = noticeDao.getRecentNotice();
//        System.out.println(notice.getTitle());

//        Notice n = new Notice();
//        n.setN_id(3);
//        n.setTitle("修改新书预告");
//        n.setDetails("修改新书即将上架");
//        n.setN_time("20200610102030");
//        noticeDao.updateNotice(n);
        noticeDao.deleteNotice("4");
    }
}
