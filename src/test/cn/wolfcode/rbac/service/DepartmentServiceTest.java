package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DepartmentServiceTest {

    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void saveOrUpdate() {
        Department department = new Department(null,"云鹂部","yunli Department");
        departmentService.saveOrUpdate(department);
    }

    @Test
    public void delete() {
        //Long类型，所以在数字后加L
        departmentService.delete(7L);
    }

    @Test
    public void getOne() {
        Department one = departmentService.getOne(5L);
        System.out.println(one);
    }

    @Test
    public void getAll() {
        List<Department> all = departmentService.getAll();
        System.out.println(all);
    }
}