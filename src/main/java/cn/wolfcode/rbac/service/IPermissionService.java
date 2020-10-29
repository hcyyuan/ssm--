package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Permission;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;

import java.util.List;

public interface IPermissionService {
    void delete(Long id);

    List<Permission> getAll();

    PageResult query(QueryObject qo);
}
