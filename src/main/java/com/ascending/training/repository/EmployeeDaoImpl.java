/*
 *  Copyright 2019, Liwei Wang <daveywang@live.com>.
 *  All rights reserved.
 *  Author: Liwei Wang
 *  Date: 06/2019
 */

package com.ascending.training.repository;

import com.ascending.training.model.Department;
import com.ascending.training.model.Employee;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Logger logger=LoggerFactory.getLogger(getClass());
    @Autowired private DepartmentDao departmentDao;

    @Override
    public Employee save(Employee employee, String deptName) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            Department department = departmentDao.getDepartmentByName(deptName);

            if (department != null) {
                transaction = session.beginTransaction();
                employee.setDepartment(department);
                session.save(employee);
                transaction.commit();
                return employee;
            }
            else {
                logger.debug(String.format("The department [%s] doesn't exist.", deptName));
            }
        }
        catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.debug(String.format("The employee %s was inserted into the table.", employee.toString()));
            logger.error(e.getMessage(),e);

        }
        return null;
    }

    @Override
    public Integer updateEmployeeAddress(String name, String address) {
        String hql = "UPDATE Employee as em set em.address = :address where em.name = :name";
        int updatedCount = 0;
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            Query<Employee> query = session.createQuery(hql);
            query.setParameter("name", name);
            query.setParameter("address", address);

            transaction = session.beginTransaction();
            updatedCount = query.executeUpdate();
            transaction.commit();
            return updatedCount;
        }
        catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        logger.debug(String.format("The employee %s was updated, total updated record(s): %d", name, updatedCount));

        return updatedCount;
    }

    @Override
    public List<Employee> getEmployees() {
        String hql = "FROM Employee em left join fetch em.accounts";

        try (Session session = sessionFactory.openSession()) {
            Query<Employee> query = session.createQuery(hql);
            return query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        }
    }

    @Override
    public Employee getEmployeeByName(String name) {
        String hql = "FROM Employee as em left join fetch em.accounts where em.name = :name";

        try (Session session = sessionFactory.openSession()) {
            Query<Employee> query = session.createQuery(hql);
            query.setParameter("name", name);

            return query.uniqueResult();
        }
    }
}
