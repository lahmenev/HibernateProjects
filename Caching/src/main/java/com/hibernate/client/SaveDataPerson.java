package com.hibernate.client;

import com.hibernate.entity.Person;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class SaveDataPerson {

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("John");

        Person person2 = new Person();
        person2.setName("Mikel");

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(person1);
        session.persist(person2);
        transaction.commit();
        session.close();
    }
}
