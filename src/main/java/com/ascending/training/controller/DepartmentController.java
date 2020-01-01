/*
 *  Copyright 2019, Liwei Wang <daveywang@live.com>.
 *  All rights reserved.
 *  Author: Liwei Wang
 *  Date: 06/2019
 */

package com.ascending.training.controller;

import com.ascending.training.model.Department;
import com.ascending.training.service.DepartmentService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/departments", "/depts"})
public class DepartmentController {
    @Autowired private Logger logger;
    @Autowired private DepartmentService departmentService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE})
    public List<Department> getDepartments() {
        List<Department> departments = departmentService.getDepartments();
        return departments;
    }

    
}