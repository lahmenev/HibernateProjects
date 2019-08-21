package com.hibernate;

import com.hibernate.entity.Phone;
import com.hibernate.entity.PhoneDetails;
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
        Session session = sessionFactory.getCurrentSession();
        System.out.println(session.hashCode());

        Phone phone1 = new Phone( "123-456-7890" );
        PhoneDetails details1 = new PhoneDetails( "T-Mobile", "GSM" );

        Phone phone2 = new Phone("555-555-5555");
        PhoneDetails details2 = new PhoneDetails("TELE 2", "4G");

        phone1.addDetails(details1);
        phone2.addDetails(details2);

        Transaction transaction = session.beginTransaction();
        session.persist(phone1);
        session.persist(phone2);
        session.flush();
        session.clear();
        transaction.commit();

        searchPhoneById(1L);

        System.out.println(getPhoneDetails(1L).getPhone().getNumber());

    }

    /**
     * Search phone by id
     *
     * @param id input parameter
     */
    private static void searchPhoneById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Phone phone = session.find(Phone.class, id);
        transaction.commit();
        System.out.println(phone.getNumber());
    }

    /**
     * Gets phone deteils
     *
     * @param id input parameter
     * @return PhoneDetails object
     */
    private static PhoneDetails getPhoneDetails(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();
        Phone phone = session.get(Phone.class, id);
        PhoneDetails details = phone.getDetails();
        transaction.commit();
        return details;
    }
}
