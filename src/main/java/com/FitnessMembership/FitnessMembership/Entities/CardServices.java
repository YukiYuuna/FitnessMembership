package com.FitnessMembership.FitnessMembership.Entities;

import javax.persistence.*;

@Entity
public class CardServices {
   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long CardId;*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ServiceId;

    /*@ManyToOne
    private Services service;*/

    /*public Long getCardId() {
        return CardId;
    }*/


    public Long getServiceId() {
        return ServiceId;
    }

    public CardServices() {
    }
}
