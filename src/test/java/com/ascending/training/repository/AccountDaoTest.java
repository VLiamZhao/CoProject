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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= AppInitializer.class)
public class AccountDaoTest {
    @Autowired
    private AccountDao accountDao;
    private Logger logger=LoggerFactory.getLogger(getClass());

    @Before
    public void init() {
    }

    @Test
    public void getAccounts() {
        List<Account> accounts = accountDao.getAccounts();
        int expectedNumOfDept = 4;
        accounts.forEach(acct -> logger.debug(acct.toString()));
        Assert.assertEquals(expectedNumOfDept, accounts.size());
    }

    @Test
    public void getEmployeeById() {
        Long id = 2L;
        Account account = accountDao.getAccountById(id);
        Assert.assertEquals(id, account.getId());
        logger.debug(account.toString());
        Employee employee = account.getEmployee();
        logger.debug(employee.getEmail());
    }
}