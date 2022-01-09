package com.FitnessMembership.FitnessMembership.payload.request;

import com.FitnessMembership.FitnessMembership.Entities.CardsAndServices.Services;

import java.io.Serializable;
import java.util.List;

public class CardRequest implements Serializable{

    public boolean isWoman() {
        return isWoman;
    }

    public void setWoman(boolean woman) {
        this.isWoman = woman;
    }

    private boolean isWoman;

    private int abonamentPeriod;

    private List<Services> cardServices;

    public int getSubscriptionPeriod() {
        return abonamentPeriod;
    }

    public void setAbonamentPeriod(int abonamentPeriod) {
        this.abonamentPeriod = abonamentPeriod;
    }

    public List<Services> getCardServices() {
        return cardServices;
    }

    public void setCardServices(List<Services> cardServices) {
        this.cardServices = cardServices;
    }
}
