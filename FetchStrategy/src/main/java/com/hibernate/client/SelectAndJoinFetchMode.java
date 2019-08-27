package com.hibernate.client;

import com.hibernate.entity.Department;
import com.hibernate.entity.Employee;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class SelectAndJoinFetchMode {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            int departmentId = 1;
            Department department = session.get(Department.class, departmentId);

            if(department != null){
                System.out.println("Department ID:" + department.getId());
                List<Employee> employees = department.getEmployees();

                for (Employee employee : employees) {
                    System.out.println("Employee ID: " + employee.getId());
                }

                System.out.println("Employees count:" + employees.size());
            }else{
                System.out.println("Department details not found with ID: " + departmentId);
            }
        }

    }
}
