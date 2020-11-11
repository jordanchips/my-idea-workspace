package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 部门
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private Integer id;
    private String departmentName;


}
