package com.jr.util;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.util
 * @version: 1.0
 */
public class PageHelper<T> {

    //1.总条数totalCount  数据库查询
    private int totalCount;
    //2.一页的条数
    private int pageSize;
    //3.第几页 页码
    private int indexPage;
    //4.一共几页
    private int totalPage;
    //5.一页的集合
    private List<T> pageList;
    //6.从第几行开始
    private int startNum;

    //get est
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(int indexPage) {
        this.indexPage = indexPage;
    }

    //计算总页数 = 总条数 / 一页的条数
    public int getTotalPage() {
        this.totalPage = totalCount % pageSize == 0 ?
                totalCount/pageSize : totalCount/pageSize+1;
        return totalPage;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    //给开始行数赋值 = （当前第几页-1） * 一页的条数
    public int getStartNum() {
        this.startNum =(indexPage-1) * pageSize;
        return startNum;
    }

    //toString
    @Override
    public String toString() {
        return "PageHelper{" +
                "totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", indexPage=" + indexPage +
                ", totalPage=" + totalPage +
                ", pageList=" + pageList +
                ", startNum=" + startNum +
                '}';
    }
}
