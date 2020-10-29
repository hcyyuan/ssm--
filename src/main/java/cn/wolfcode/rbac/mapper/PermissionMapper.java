package cn.wolfcode.rbac.mapper;

import cn.wolfcode.rbac.domain.Permission;
import cn.wolfcode.rbac.query.QueryObject;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    int selectForCount();

    List<Permission> selectForData(QueryObject qo);
}