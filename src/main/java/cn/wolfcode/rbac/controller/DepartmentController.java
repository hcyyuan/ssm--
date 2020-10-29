package cn.wolfcode.rbac.controller;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//先写Controller注解，创建接口对象，写方法
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    //查询所有的方法   model 载具
    @RequestMapping("/list")
    public String selectAll(Model model, QueryObject qo) {
        //List<Department> all = departmentService.getAll();
        PageResult all = departmentService.query(qo);   //带有分页效果的结果集
        model.addAttribute("pageResult", all);
        //请求转发，可以携带参数
        //return "forward:/WEB-INF/views/department/list.jsp";
        //简写
        return "department/list";
    }

    //删除操作
    @RequestMapping("/delete")
    public String delete(Long id) {
        departmentService.delete(id);
        //重定向，重新发送一次请求
        return "redirect:/department/list";
    }

    //跳转到 input 页面的操作
    @RequestMapping("/input")
    public String input(Long id, Model model) {
        //添加操作，不需要携带参数，直接请求转发/重定向
        //编辑操作，需要携带参数，做数据回显，请求转发
        if (id != null) {
            Department one = departmentService.getOne(id);
            model.addAttribute("d", one);
        }
        return "department/input";
    }

    //在 input 页面 添加完数据 / 修改完数据之后，点击保存按钮
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Department department) {
        departmentService.saveOrUpdate(department);
        //重定向到list页面，重新查一次最新的数据   请求转发速度比重定向快
        return "redirect:/department/list";
    }
}
