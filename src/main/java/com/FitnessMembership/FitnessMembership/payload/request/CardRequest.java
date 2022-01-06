package com.FitnessMembership.FitnessMembership.payload.request;

import com.FitnessMembership.FitnessMembership.Entities.CardsAndServices.Services;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CardRequest implements Serializable{

    private int abonamentPeriod;

    private List<Services> cardServices;

    public int getAbonamentPeriod() {
        return abonamentPeriod;
    }

    public void setAbonamentPeriod(int abonamentPeriodl) {
        this.abonamentPeriod = abonamentPeriod;
    }

    public List<Services> getCardServices() {
        return cardServices;
    }

    public void setCardServices(List<Services> cardServices) {
        this.cardServices = cardServices;
    }
}
