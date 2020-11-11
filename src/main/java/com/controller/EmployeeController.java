package com.controller;

import com.mapper.DepartmentMapper;
import com.mapper.EmployeeMapper;
import com.pojo.Department;
import com.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

/**
 * Description: 处理员工管理请求
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeDao;
    @Autowired
    DepartmentMapper departmentDao;

    //侧边栏的'员工管理'，返回全部员工的信息
    @RequestMapping("/emps")
    public String list(Model model) {
        //查出所有员工的信息
        List<Employee> employees = employeeDao.getEmployees();

        for (Employee e : employees) {
            System.out.println(e);
        }

        model.addAttribute("emps", employees);
        return "employees/list";
    }

    //顶部栏的'添加员工'，进入添加员工页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //查出所有部门的信息
        List<Department> departments = departmentDao.getDepartments();

        //测试
        /*for (Department d : departments) {
            System.out.println(d);
        }*/

        model.addAttribute("deps", departments);
        return "employees/add";
    }

    //添加页面的'提交'，返回员工列表
    @PostMapping("/emp2")
    public String toListPage1(Employee employee) {
        //调用底层业务方法保存员工信息
        employeeDao.addEmployee(employee);
        return "redirect:/emps";
    }

    //员工列表的'编辑'，进入修改页面
    @GetMapping("/updateEmp")
    public String toUpdatePage(Integer id, Model model) {
        //点击'编辑'会传来id，根据id查出员工的信息
        Employee employee = employeeDao.getEmployee(id);
        model.addAttribute("emp", employee);
        //查出所有部门的信息
        List<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps", departments);
        return "employees/update";
    }

    //修改页面的'提交'，返回员工列表
    @PostMapping("/update")
    public String toListPage2(Employee employee) {
        //调用底层业务方法保存员工信息
        employeeDao.updateEmployee(employee);
        return "redirect:/emps";
    }

    //员工列表的'删除'，删除用户
    @GetMapping("/deleteEmp")
    public String deleteEmp(Integer id) {
        employeeDao.deleteEmployee(id);
        return "redirect:/emps";
    }

}
