package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.query.EmployeeQueryObject;
import cn.wolfcode.rbac.query.PageResult;

import java.util.List;

public interface IEmployeeService {

    void saveOrUpdate(Employee employee);

    void delete(Long id);

    Employee getOne(Long id);

    List<Employee> getAll();

    PageResult query(EmployeeQueryObject qo);

    void saveEmpAndRoleRelation(Long id, Long[] roleIds);
}
