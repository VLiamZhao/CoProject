/*
 *  Copyright 2019, Liwei Wang <daveywang@live.com>.
 *  All rights reserved.
 *  Author: Liwei Wang
 *  Date: 06/2019
 */

package com.ascending.training.repository;


import com.ascending.training.init.AppInitializer;
import com.ascending.training.model.Account;
import com.ascending.training.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= AppInitializer.class)
public class EmployeeDaoTest {
    @Autowired
    private EmployeeDao employeeDao;
    private String deptName = "HR";

    @Before
    public void init() {
    }

    @Test
    public void getEmployees() {
        List<Employee> employees = employeeDao.getEmployees();
        int expectedNumOfDept = 4;
        employees.forEach(em -> System.out.println(em.toString()));
        Assert.assertEquals(expectedNumOfDept, employees.size());
    }

    @Test
    public void updateEmployeeAddress() {
        String name = "dwang";
        String address = "11126 Fairhaven Court, Fairfax, VA";
        employeeDao.updateEmployeeAddress(name, address);
        Employee employee = employeeDao.getEmployeeByName(name);
        Assert.assertEquals(address, employee.getAddress());
    }

    
}