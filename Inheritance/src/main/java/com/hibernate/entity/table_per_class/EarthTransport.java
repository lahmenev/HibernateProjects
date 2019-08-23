package com.hibernate.entity.table_per_class;

import javax.persistence.Entity;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
@Entity
public class EarthTransport extends Transport {
    private String typeGear;

    public String getTypeGear() {
        return typeGear;
    }

    public void setTypeGear(String typeGear) {
        this.typeGear = typeGear;
    }
}
