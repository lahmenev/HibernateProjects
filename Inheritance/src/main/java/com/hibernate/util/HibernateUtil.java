package com.hibernate.util;

import com.hibernate.entity.joined.Account;
import com.hibernate.entity.joined.CreditAccount;
import com.hibernate.entity.joined.DebitAccount;
import com.hibernate.entity.single_table.FourWheeler;
import com.hibernate.entity.single_table.TwoWheeler;
import com.hibernate.entity.single_table.Vehicle;
import com.hibernate.entity.table_per_class.Transport;
import com.hibernate.entity.table_per_class.FlyTransport;
import com.hibernate.entity.table_per_class.EarthTransport;
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

//        configuration.addAnnotatedClass(Vehicle.class);
//        configuration.addAnnotatedClass(FourWheeler.class);
//        configuration.addAnnotatedClass(TwoWheeler.class);
//
//        configuration.addAnnotatedClass(Transport.class);
//        configuration.addAnnotatedClass(FlyTransport.class);
//        configuration.addAnnotatedClass(EarthTransport.class);

        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(CreditAccount.class);
        configuration.addAnnotatedClass(DebitAccount.class);

        concreteSessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return concreteSessionFactory;
    }


}
