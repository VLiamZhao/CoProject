/*
 *  Copyright 2019, Liwei Wang <daveywang@live.com>.
 *  All rights reserved.
 *  Author: Liwei Wang
 *  Date: 06/2019
 */

package com.ascending.training.service;

import com.ascending.training.model.Account;
import com.ascending.training.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired private AccountDao accountDao;

    public Account save(Account account, String employeeName) {
        return accountDao.save(account, employeeName);
    }

    public List<Account> getAccounts() {
        return accountDao.getAccounts();
    }

    public Account getAccountById(Long id) {
        return accountDao.getAccountById(id);
    }
}
