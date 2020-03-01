/*
 *  Copyright 2019, Liwei Wang <daveywang@live.com>.
 *  All rights reserved.
 *  Author: Liwei Wang
 *  Date: 06/2019
 */

package com.ascending.training.jdbc;

import com.ascending.training.model.Employee;
import java.sql.*;

public class EmployeeDao {
    private static final String DB_URL = "jdbc:postgresql://localhost:5431/training_dev";
    private static final String USER = "admin";
    private static final String PASS = "password";

    public Employee getEmployee(String employeeName) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Employee employee = null;

       
}

