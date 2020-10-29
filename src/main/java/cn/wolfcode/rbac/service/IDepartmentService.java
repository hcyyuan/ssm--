package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;

import java.util.List;

public interface IDepartmentService {
    //增加操作
    //void save(Department department);

    //增加或修改操作  小驼峰命名法用于方法名命名和字段名命名
    //通过id来判断调用的是save还是update
    void saveOrUpdate(Department department);

    //修改操作
    //void update(Department department);

    //删除操作
    void delete(Long id);

    //查询单个
    Department getOne(Long id);

    //查询所有
    List<Department> getAll();

    PageResult query(QueryObject qo);
}
