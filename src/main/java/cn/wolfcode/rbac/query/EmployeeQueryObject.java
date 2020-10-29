package cn.wolfcode.rbac.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

@Getter
@Setter
public class EmployeeQueryObject extends QueryObject{
    private String keyword;   //关键字
    private Long deptId = -1L;  //部门id，设置默认值查询全部

    public String getKeyword(){
        return StringUtils.isEmpty(keyword) ? null : keyword;
    }
}
