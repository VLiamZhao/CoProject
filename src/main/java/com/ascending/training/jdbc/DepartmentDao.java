/*
 *  Copyright 2019, Liwei Wang <daveywang@live.com>.
 *  All rights reserved.
 *  Author: Liwei Wang
 *  Date: 06/2019
 */

package com.ascending.training.jdbc;

import com.ascending.training.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    //STEP 1: Database information
    static final String DB_URL = "jdbc:postgresql://localhost:5431/training_dev";
    static final String USER = "admin";
    static final String PASS = "password";

    public List<Department> getDepartments() {
        List<Department> departments = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

       
    }

}

