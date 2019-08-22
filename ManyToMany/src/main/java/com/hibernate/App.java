package com.hibernate;

import com.hibernate.entity.Car;
import com.hibernate.entity.Employee;
import com.hibernate.entity.UserDetails;
import com.hibernate.entity.Vehicle;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class App {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        //doWithoutJoinTable();

        doJoinTable();
    }

    private static void doJoinTable() {
        Employee employee = new Employee();
        employee.setName("Sergo");

        Car car1 = new Car();
        car1.setCarName("BMV");
        Car car2 = new Car();
        car2.setCarName("Volvo");

        employee.getCars().add(car1);
        employee.getCars().add(car2);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(employee);

//        employee.getCars().remove(car1);

        session.getTransaction().commit();
        session.close();
    }

    private static void doWithoutJoinTable() {
        UserDetails user = new UserDetails();
        user.setUserName("First User");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Car");
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Jeep");

        user.getVehicleList().add(vehicle1);
        user.getVehicleList().add(vehicle2);
        vehicle1.getUserList().add(user);
        vehicle2.getUserList().add(user);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
    }
}
