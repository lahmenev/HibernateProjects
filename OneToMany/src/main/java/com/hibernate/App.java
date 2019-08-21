package com.hibernate;

import com.hibernate.entity.Passport;
import com.hibernate.entity.Person;
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

    public static void main(String[] args) {
        Session session = sessionFactory.openSession();
        Person person = new Person("Sergey");

        Passport rusPassport = new Passport("11223");
        Passport engPassport = new Passport("44444");

        Transaction transaction = session.beginTransaction();
        person.getPassports().add(rusPassport);
        person.getPassports().add(engPassport);
        session.persist(person);

        System.out.println(session.find(Person.class, 1).getName());
        transaction.commit();
        session.close();

        getPerson(1);
    }

    /**
     * Prints person with given id.
     */
    private static void getPerson(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        System.out.println(session.find(Person.class, id).getName());
        transaction.commit();
    }
}
