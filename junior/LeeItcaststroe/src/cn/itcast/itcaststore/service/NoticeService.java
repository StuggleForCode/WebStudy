package cn.itcast.itcaststore.service;

import cn.itcast.itcaststore.dao.NoticeDao;
import cn.itcast.itcaststore.domain.Notice;

import java.sql.SQLException;
import java.util.List;

/**
 * 公告服务类
 */
public class NoticeService {
    private NoticeDao noticeDao= new NoticeDao();
    //1.后台系统，查询所有公告
    public List<Notice> getAllNotices(){

        try {
            return noticeDao.getAllNotices();
        } catch (SQLException throwables) {
            throw new RuntimeException("查询所公告失败");
        }
    }

    //2.后台系统，根据id查找公告
    public Notice findNoticeById(String n_id){
        try {
            return noticeDao.findNoticeById(n_id);
        } catch (SQLException throwables) {
            throw new RuntimeException();
        }
    }
    
    //3.前台系统，查询最新添加或修改的一条公告
    public Notice getRecentNotice(){
        try {
            return noticeDao.getRecentNotice();
        } catch (SQLException throwables) {
            throw new RuntimeException("查询最新添加或修改的一条公告失败");
        }
    }

    //4.后台系统，添加公告
    public void addNotice(Notice notice){
        try {
            noticeDao.addNotice(notice);
        } catch (SQLException throwables) {
            throw new RuntimeException("添加公告失败");
        }
    }

    //5.后台系统，根据id修改公告
    public void updateNotice(Notice notice){
        try {
            noticeDao.updateNotice(notice);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //6.后台系统，根据id删除公告
    public void deleteNotice(String n_id){
        try {
            noticeDao.deleteNotice(n_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void main(String[] args) {
        NoticeService service = new NoticeService();
//        List<Notice> list = service.getAllNotices();
//        for(Notice n:list){
//            System.out.println(n.getDetails());
//        }

//        Notice n = service.findNoticeById("1");
//        System.out.println(n.getDetails());

//        Notice n = service.getRecentNotice();
//        System.out.println(n.getTitle());
//          Notice n = new Notice();
//          n.setN_id(5);
//          n.setTitle("新书预告");
//          n.setDetails("新书即将上架");
//          n.setN_time("20200610102030");
//          service.updateNotice(n);
            service.deleteNotice("5");
    }

}
