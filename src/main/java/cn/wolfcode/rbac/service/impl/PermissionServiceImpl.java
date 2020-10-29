package cn.wolfcode.rbac.service.impl;

import cn.wolfcode.rbac.domain.Permission;
import cn.wolfcode.rbac.mapper.PermissionMapper;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public void delete(Long id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Permission> getAll() {
        List<Permission> permissions = permissionMapper.selectAll();
        return permissions;
    }

    @Override
    public PageResult query(QueryObject qo) {
        int totalCount = permissionMapper.selectForCount();

        if (totalCount != 0) {
            List<Permission> data = permissionMapper.selectForData(qo);
            return new PageResult(data, totalCount, qo.getCurrentPage(), qo.getPageSize());
        }
        return new PageResult(qo.getCurrentPage(), qo.getPageSize());
    }
}
