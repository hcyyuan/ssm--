package cn.wolfcode.rbac.service.impl;

import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.mapper.EmployeeMapper;
import cn.wolfcode.rbac.query.EmployeeQueryObject;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void saveOrUpdate(Employee employee) {
        if (employee.getId() == null) {
            employeeMapper.insert(employee);
        } else {
            employeeMapper.updateByPrimaryKey(employee);
        }
    }

    @Override
    public void delete(Long id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Employee getOne(Long id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = employeeMapper.selectAll();
        return employees;
    }

    @Override
    public PageResult query(EmployeeQueryObject qo) {
        int totalCount = employeeMapper.selectForCount(qo);
        if (totalCount != 0) {
            List<Employee> data = employeeMapper.selectForData(qo);
            return new PageResult(data, totalCount, qo.getCurrentPage(),qo.getPageSize());
        } else {
            return new PageResult(qo.getCurrentPage(), qo.getPageSize());
        }
    }

    @Override
    public void saveEmpAndRoleRelation(Long empId, Long[] roleIds) {
        //删除员工和角色的旧关系
        if (empId != null) {
            employeeMapper.deleteEmpAndRoleRelation(empId);
        }
        //快捷键 iter
        if (roleIds != null) {
            for (Long roleId : roleIds) {
                //保存员工和角色的关系到数据库
                employeeMapper.saveEmpAndRoleRelation(empId, roleId);
            }
        }

    }
}
