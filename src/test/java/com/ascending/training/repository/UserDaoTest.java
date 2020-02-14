/*
 *  Copyright 2019, Liwei Wang <daveywang@live.com>.
 *  All rights reserved.
 *  Author: Liwei Wang
 *  Date: 06/2019
 */

package com.ascending.training.repository;


import com.ascending.training.init.AppInitializer;
import com.ascending.training.model.Role;
import com.ascending.training.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= AppInitializer.class)
public class UserDaoTest {
    private Logger logger=LoggerFactory.getLogger(getClass());
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    private User user;
    private String email;
    private List<Role> roles = new ArrayList();

   
}