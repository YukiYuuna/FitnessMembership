package com.FitnessMembership.FitnessMembership.Entities.CardsAndServices;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

//Composite key class

@Embeddable
@Entity
public class CardServices implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long CardId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ServiceId;


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
}
