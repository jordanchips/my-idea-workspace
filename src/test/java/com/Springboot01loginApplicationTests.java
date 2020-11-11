package com;

import com.mapper.EmployeeMapper;
import com.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class Springboot01loginApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    void contextLoads() {

        Employee employee = new Employee();
        employee.setName("1");
        employee.setGender(1);
        employee.setDepartmentId(11);
        employee.setBirth(new Date());
        employee.setEmail("2");
        employeeMapper.addEmployee(employee);

    }
}
