package cn.wolfcode.rbac.query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryObject {
    private int currentPage = 1;   //当前页
    private int pageSize = 5;    //每页显示的数据量

    //计算每页的起始索引
    public int getStart() {
        return (currentPage - 1)*pageSize;
    }
}
