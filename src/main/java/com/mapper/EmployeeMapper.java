package com.mapper;

import com.pojo.Department;
import com.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Description: 员工dao
 */

@Mapper
@Repository
public interface EmployeeMapper {

    //模拟数据库中的数据
    //private static Map<Integer, Employee> employees = null;

    //员工所属的部门
    /*@Autowired
    private DepartmentMapper departmentDao;*/

    /*static {
        employees = new HashMap<Integer, Employee>(); //创建一个员工表

        employees.put(1001, new Employee(1001, "陈泽", "1111@qq.com", new Department(101, "综合部"), 1));
        employees.put(1002, new Employee(1002, "何琴", "1111@qq.com", new Department(102, "市场部"), 1));
        employees.put(1003, new Employee(1003, "娜美", "1111@qq.com", new Department(103, "财务部"), 0));

    }*/

    //主键自增
    //private static Integer initId = 1001;

    //增加一个员工（如果员工没有id，就算新增；如果已经有id，就算修改员工信息）
    /*public void addEmployee(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        *//**
         * 这里不太懂，设定员工部门的前提是：我不知道这个员工是什么部门，所以才要设定
         * 这里的意思：员工已经有部门了，后台来给他录入信息。员工提供部门id，后台用dao根据部门id定位部门信息，最后set()录入。
         *//*
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);
    }*/

    //增加一个员工的信息
    public int addEmployee(Employee employee);

    //通过id删除员工信息
    public int deleteEmployee(Integer id);

    //修改一个员工的信息
    public int updateEmployee(Employee employee);

    //得到全部员工的信息
    public List<Employee> getEmployees();

    //通过id获得员工信息
    public Employee getEmployee(Integer id);



}
