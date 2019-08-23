package com.hibernate.entity.single_table;

import javax.persistence.*;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
//  It is the same as only @Inheritance and without this annotation
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Inheritance
@DiscriminatorColumn(
        name = "vehicle_type",
        discriminatorType = DiscriminatorType.STRING
)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String vehicleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
