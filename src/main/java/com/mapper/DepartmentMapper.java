package com.mapper;

import com.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Description: 部门dao
 */

@Mapper
@Repository
public interface DepartmentMapper {

    //模拟数据库中的数据
    //private static Map<Integer, Department> departments = null;

    /*static {
        departments = new HashMap<Integer, Department>(); //创建一个部门表

        departments.put(101, new Department(101, "综合部"));
        departments.put(102, new Department(102, "市场部"));
        departments.put(103, new Department(103, "财务部"));
        departments.put(104, new Department(104, "小卖部"));

    }*/

    //获取所有部门信息
    List<Department> getDepartments();

    //通过id得到部门信息
    Department getDepartmentById(Integer id);



}
