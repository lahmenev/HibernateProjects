package com.hibernate.entity.table_per_class;

import javax.persistence.Entity;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
@Entity
public class FlyTransport extends Transport {
    private int wingsLength;

    public int getWingsLength() {
        return wingsLength;
    }

    public void setWingsLength(int wingsLength) {
        this.wingsLength = wingsLength;
    }
}
