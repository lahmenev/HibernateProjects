package com.hibernate.client;

import com.hibernate.entity.Person;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Cache;
import org.hibernate.Session;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class SecondLevelCache {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        System.out.println("First person object");
        Person person = session.load(Person.class, 1);
        System.out.println(person.getName());
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Second person object");
        Person person1 = session.load(Person.class, 1);
        System.out.println(person1.getName());
        session.close();
    }
}
