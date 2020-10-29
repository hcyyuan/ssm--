package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;

import java.util.List;

public interface IRoleService {
    //保存或修改操作
    void saveOrUpdate(Role role);
    //删除操作
    void delete(Long id);
    //查询单个
    Role getOne(Long id);
    //查询所有
    List<Role> getAll();

    PageResult query(QueryObject qo);
}
