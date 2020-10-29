package cn.wolfcode.rbac.controller;

import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    //查询所有的方法
    @RequestMapping("/list")
    public String selectAll(Model model, QueryObject qo) {
        PageResult all = roleService.query(qo);
        model.addAttribute("pageResult", all);
        return "role/list";
    }

    //删除操作
    @RequestMapping("/delete")
    public String delete(Long id) {
        roleService.delete(id);
        return "redirect:/role/list";
    }

    //跳转到 input 页面的操作
    @RequestMapping("/input")
    public String input(Long id, Model model) {
        if (id != null) {
            Role one = roleService.getOne(id);
            model.addAttribute("role", one);
        }
        return "role/input";
    }

    //在 input 页面 添加完数据 / 修改完数据之后，点击保存按钮
    public String saveOrUpdate(Role role) {
        roleService.saveOrUpdate(role);
        return "redirect:/role/input";
    }
}
