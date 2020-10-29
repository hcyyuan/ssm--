package cn.wolfcode.rbac.mapper;

import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.query.EmployeeQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    int selectForCount(EmployeeQueryObject qo);

    List<Employee> selectForData(EmployeeQueryObject qo);

    void saveEmpAndRoleRelation(@Param("empId") Long empId, @Param("roleId") Long roleId);

    void deleteEmpAndRoleRelation(Long empId);
}