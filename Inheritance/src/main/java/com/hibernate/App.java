package com.hibernate;

import com.hibernate.entity.single_table.FourWheeler;
import com.hibernate.entity.single_table.TwoWheeler;
import com.hibernate.entity.single_table.Vehicle;
import com.hibernate.entity.table_per_class.Transport;
import com.hibernate.entity.table_per_class.FlyTransport;
import com.hibernate.entity.table_per_class.EarthTransport;
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
        //doSingleTable();

        doTablePerClass();
    }

    private static void doTablePerClass() {
        Transport transport = new Transport();
        transport.setName("Car");

        FlyTransport airbus = new FlyTransport();
        airbus.setName("airbus");
        airbus.setWingsLength(20);

        EarthTransport jeep = new EarthTransport();
        jeep.setName("jeep");
        jeep.setTypeGear("full");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(transport);
        session.persist(airbus);
        session.persist(jeep);
        session.getTransaction().commit();
        session.close();
    }

    private static void doSingleTable() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        TwoWheeler bike = new TwoWheeler();
        bike.setVehicleName("Bike");
        bike.setSteeringHandle("Bike steering handle");

        FourWheeler car = new FourWheeler();
        car.setVehicleName("Porsche");
        car.setSteeringWheel("Porsche steering wheel");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(vehicle);
        session.persist(bike);
        session.persist(car);
        session.getTransaction().commit();
        session.close();
    }
}
