package com.hibernate.util;

import com.hibernate.entity.Person;
import com.hibernate.entity.Passport;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class HibernateUtil {
    private static final SessionFactory concreteSessionFactory;

    static {
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate_example?useLegacyDatetimeCode=false&amp&serverTimezone=UTC");
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.setProperty("hibernate.connection.username", "root");
        properties.setProperty("hibernate.connection.password", "1q2w3e4r5t6y");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.current_session_context_class", "thread");

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Passport.class);
        concreteSessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return concreteSessionFactory;
    }


}
