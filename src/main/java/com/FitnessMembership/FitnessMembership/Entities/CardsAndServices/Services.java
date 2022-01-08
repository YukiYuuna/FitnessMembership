package com.FitnessMembership.FitnessMembership.Entities.CardsAndServices;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @ManyToMany(mappedBy = "CardServices")
    private List<Card> ServicedCards;

    private String serviceName;

    private String description;

    public Long getId() {
        return Id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Services() {
    }



    public Services(String serviceName, String description) {
        this.serviceName = serviceName;
        this.description = description;
    }
}
