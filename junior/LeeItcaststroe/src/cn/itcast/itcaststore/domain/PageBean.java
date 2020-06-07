package cn.itcast.itcaststore.domain;

import java.util.List;

public class PageBean {
    private int currentPage;//当前页面
    private int totalCount;//总条数
    private int totalPage;//总页数
    private int currentCount;//每页条数
    private List<Product> ps;//每页显示的数据
    private String category; //类别
    private String searchfiled;//模糊搜索的书名

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public List<Product> getPs() {
        return ps;
    }

    public void setPs(List<Product> ps) {
        this.ps = ps;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSearchfiled() {
        return searchfiled;
    }

    public void setSearchfiled(String searchfiled) {
        this.searchfiled = searchfiled;
    }
}
