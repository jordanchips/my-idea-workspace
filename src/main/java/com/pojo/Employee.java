package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description:员工
 */

@Data
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String name;
    private String email;
    private Integer departmentId;
    private Integer gender; //0：女  1：男
    private Date birth;

    public Employee(Integer id, String name, String email, Integer departmentId, Integer gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
        this.gender = gender;

        //默认创建日期
        this.birth = new Date();
    }
}
