package com.hibernate.entity.table_per_class;

import javax.persistence.*;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Transport {

    @Id
    @GeneratedValue
    private int id;
    private String transportName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return transportName;
    }

    public void setName(String name) {
        this.transportName = name;
    }
}
