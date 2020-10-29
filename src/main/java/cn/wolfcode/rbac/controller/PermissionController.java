package cn.wolfcode.rbac.controller;

import cn.wolfcode.rbac.domain.Permission;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/list")
    public String selectAll(Model model, QueryObject qo) {
        PageResult all = permissionService.query(qo);
        model.addAttribute("pageResult", all);
        return "permission/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        permissionService.delete(id);
        return "redirect:/permission/list";
    }
}
