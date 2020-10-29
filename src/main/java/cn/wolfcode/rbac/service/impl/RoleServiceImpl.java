package cn.wolfcode.rbac.service.impl;

import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.mapper.RoleMapper;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void saveOrUpdate(Role role) {
        if (role.getId() == null) {
            roleMapper.insert(role);
        } else {
            roleMapper.updateByPrimaryKey(role);
        }
    }

    @Override
    public void delete(Long id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Role getOne(Long id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        return role;
    }

    @Override
    public List<Role> getAll() {
        List<Role> roles = roleMapper.selectAll();
        return roles;
    }

    @Override
    public PageResult query(QueryObject qo) {
        int totalCount = roleMapper.selectForCount();

        PageResult pageResult;
        if (totalCount != 0) {
            List<Role> data = roleMapper.selectForData(qo);
            pageResult = new PageResult(data, totalCount, qo.getCurrentPage(), qo.getPageSize());
        } else {
            pageResult = new PageResult(qo.getCurrentPage(), qo.getPageSize());
        }
        return pageResult;
    }
}
