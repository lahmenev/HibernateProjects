package com.hibernate.entity.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
@Entity
@PrimaryKeyJoinColumn(name = "account_id")
public class DebitAccount extends Account {

    private int overdraftFee;

    public int getOverdraftFee() {
        return overdraftFee;
    }

    public void setOverdraftFee(int overdraftFee) {
        this.overdraftFee = overdraftFee;
    }
}
