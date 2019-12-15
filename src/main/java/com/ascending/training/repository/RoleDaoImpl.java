/*
 *  Copyright 2019, Liwei Wang <daveywang@live.com>.
 *  All rights reserved.
 *  Author: Liwei Wang
 *  Date: 06/2019
 */

package com.ascending.training.repository;

import com.ascending.training.model.Role;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Logger logger=LoggerFactory.getLogger(getClass());
    @Override
    public Role getRoleByName(String name) {
        String hql = "FROM Role as r where lower(r.name) = :name";
        try (Session session = sessionFactory.openSession()) {
            Query<Role> query = session.createQuery(hql);
            query.setParameter("name", name.toLowerCase());
            return query.uniqueResult();
        }
    }
}
