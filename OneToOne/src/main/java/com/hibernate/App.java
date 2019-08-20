package com.hibernate;

import com.hibernate.entity.Address;
import com.hibernate.entity.Employee;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class App {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private static Employee employee1 = new Employee("Sergey", "Lakhmenev");
    private static Address address1 = new Address("Saint-P", "Kondratievski", employee1);

    private static Employee employee2 = new Employee("Sergey2", "Lakhmenev2");
    private static Address address2 = new Address("Saint-P2", "Kondratievski2", employee2);

    public static void main(String[] args) {
        Session session = sessionFactory.openSession();

        session.save(employee1);
        session.save(address1);

        session.save(employee2);
        session.save(address2);

        System.out.println(session.get(Employee.class, 1));

        removeAddress(1);

        //Here we get exception (CascadeType - could not remove data from main table)
        removeEmployee(1);

        session.close();
    }

    private static void removeEmployee(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.delete(employee);
        transaction.commit();
    }

    private static void removeAddress(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Address address = session.get(Address.class, id);
        session.delete(address);
        transaction.commit();
    }
}
