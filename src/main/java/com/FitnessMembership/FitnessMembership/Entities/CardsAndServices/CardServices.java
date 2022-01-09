package com.FitnessMembership.FitnessMembership.Entities.CardsAndServices;

import com.FitnessMembership.FitnessMembership.Entities.CardsAndServices.keys.CardServicesKey;

import javax.persistence.*;

//Composite key class


@Entity
public class CardServices {

    @EmbeddedId
    private CardServicesKey id;

    @ManyToOne
    @MapsId("cardId")
    @JoinColumn(name = "CardId")
    private Card card;

    @ManyToOne
    @MapsId("serviceId")
    @JoinColumn(name = "ServiceId")

    private Services services;


    public CardServices() {
    }


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    /*

    public Long getCardId() {
        return CardId;
    }


    public Long getServiceId() {
        return ServiceId;
    }

    public CardServices() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardServices that = (CardServices) o;
        return Objects.equals(CardId, that.CardId) && Objects.equals(ServiceId, that.ServiceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CardId, ServiceId);
    }

    */
}
