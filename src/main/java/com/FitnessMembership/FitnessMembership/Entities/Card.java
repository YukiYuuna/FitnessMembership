package com.FitnessMembership.FitnessMembership.Entities;

import javax.persistence.*;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String serialNumber;

    /*@ManyToOne
    private Services Service;*/

    public Card(String serialNumber, Boolean valid) {
        this.serialNumber = serialNumber;
        this.valid = valid;
    }

    public Card() {
    }

    public Long getId() {
        return Id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    private Boolean valid;

}
