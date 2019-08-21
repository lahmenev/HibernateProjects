package com.hibernate.entity;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;

    @OneToOne(
            mappedBy = "phone",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private PhoneDetails details;

    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
    }

    public void addDetails(PhoneDetails details) {
        details.setPhone( this );
        this.details = details;
    }

    public void removeDetails() {

        if (details != null) {
            details.setPhone(null);
            this.details = null;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneDetails getDetails() {
        return details;
    }

    public void setDetails(PhoneDetails details) {
        this.details = details;
    }
}
