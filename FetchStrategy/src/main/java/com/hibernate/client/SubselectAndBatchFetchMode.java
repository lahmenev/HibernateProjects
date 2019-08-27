package com.hibernate.client;

import com.hibernate.entity.Department;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class SubselectAndBatchFetchMode {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Department> departments = session.createQuery("From Department", Department.class)
                    .list();
            System.out.println("Fetched Departments size:" + departments.size());

            for (Department department : departments) {
                System.out.println("Department ID:" + department.getId());
                System.out.println("Employees count:" + department.getEmployees().size());
            }
        }
    }
}
