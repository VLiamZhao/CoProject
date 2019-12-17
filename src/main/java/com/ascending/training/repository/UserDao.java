/*
 *  Copyright 2019, Liwei Wang <daveywang@live.com>.
 *  All rights reserved.
 *  Author: Liwei Wang
 *  Date: 06/2019
 */

package com.ascending.training.repository;

import com.ascending.training.model.User;

public interface UserDao {
    User save(User user);
    User findById(Long Id);
    User getUserByEmail(String email);
    User getUserByCredentials(String email, String password);
    void delete(User u);
}
