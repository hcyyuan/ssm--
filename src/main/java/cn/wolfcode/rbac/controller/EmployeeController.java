package cn.wolfcode.rbac.controller;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.query.EmployeeQueryObject;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.service.IDepartmentService;
import cn.wolfcode.rbac.service.IEmployeeService;
import cn.wolfcode.rbac.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/list")
    public String selectAll(Model model, @ModelAttribute("qo") EmployeeQueryObject qo) {
        PageResult all = employeeService.query(qo);
        model.addAttribute("pageResult", all);
        List<Department> all1 = departmentService.getAll();
        model.addAttribute("departments", all1);
        return "employee/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        employeeService.delete(id);
        return "redirect:/employee/list";
    }

    //跳转到 input 页面的操作
    @RequestMapping("/input")
    public String input(Long id, Model model) {
        //添加操作，不需要携带参数，直接请求转发/重定向
        //编辑操作，需要携带参数，做数据回显，请求转发
        if (id != null) {
            Employee one = employeeService.getOne(id);
            model.addAttribute("employee", one);
        }

        //查询部门下拉框
        List<Department> all = departmentService.getAll();
        model.addAttribute("departments", all);

        //角色列表
        List<Role> all1 = roleService.getAll();
        model.addAttribute("roles", all1);

        return "employee/input";
    }

    //在 input 页面 添加完数据 / 修改完数据之后，点击保存按钮
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Employee employee, Long[] roleIds) {
        employeeService.saveOrUpdate(employee);

        //保存员工和角色的信息
        employeeService.saveEmpAndRoleRelation(employee.getId(), roleIds);
        //重定向到list页面，重新查一次最新的数据   请求转发速度比重定向快
        return "redirect:/employee/list";
    }
}
