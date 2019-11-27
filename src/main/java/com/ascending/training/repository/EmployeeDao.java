/*
 *  Copyright 2019, Liwei Wang <daveywang@live.com>.
 *  All rights reserved.
 *  Author: Liwei Wang
 *  Date: 06/2019
 */

package com.ascending.training.repository;

import com.ascending.training.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee save(Employee employee, String deptName);
    Integer updateEmployeeAddress(String name, String address);
    List<Employee> getEmployees();
    Employee getEmployeeByName(String name);
}
