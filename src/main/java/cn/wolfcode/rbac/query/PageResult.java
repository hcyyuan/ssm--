package cn.wolfcode.rbac.query;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class PageResult {
    //从数据库查出来的
    private List data;  //数据集
    private int totalCount;   //总条数

    //用户传过来的
    private int currentPage;   //当前页
    private int pageSize;    //每页显示的数据量

    //需要我们计算的
    private int totalPage;    //总页数
    private int prevPage;    //上一页
    private int nextPage;    //下一页

    //全参构造器   数据库有满足条件的数据，需要接收四个参数
    public PageResult(List data, int totalCount, int currentPage, int pageSize) {
        this.data = data;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;

        //需要计算的三个字段
        this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize+1;
        this.prevPage = currentPage > 1 ? currentPage - 1 : 1;
        this.nextPage = currentPage < this.totalPage ? currentPage + 1 : this.totalPage;
    }

    //缺参构造器   数据库没有满足条件的数据，只需接收用户传过来的两个参数，此时调用缺参构造器
    public PageResult(int currentPage, int pageSize) {
        this.data = Collections.emptyList();
        this.totalCount = 0;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
}
