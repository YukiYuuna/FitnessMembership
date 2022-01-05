package com.FitnessMembership.FitnessMembership.Entities.CardsAndServices;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    static private int serialNumber = 0;

    private Boolean valid;


    //При всяко повторно зареждане на картата ще бъде зададена дата на зареждането в конструктора
    private Timestamp cardCharged;

    private LocalDate expirationDate;

    //Ще се въвежда в месеци , при карта с 8 , 16 .... тренировки ще важи един месец
    static private int [] abonamentPeriods = {1 , 3 , 6 , 12};

    private int abonamentPeriod;

    //Ще брой броя на посещенията и ще се нулира в конструктора ;)
    //private int visitsCounter;


    @ManyToMany
            @JoinTable(name = "CardServices"
            , joinColumns = @JoinColumn(name = "CardId"),
                    inverseJoinColumns = @JoinColumn(name = "ServiceId"))
    Set<Services> CardServices;


    //Нова карта ще създаваме само с абонаментен период и видове услуги , другите полета си ги призчисляваме
    // и са си за нас
    public Card(int abonamentPeriod ,  Set<Services> cardServices) {
        ++serialNumber;

        //При създаване абонамента е задължителен , тъй че по дефоут е валидна
        this.valid = true;


        this.cardCharged = new Timestamp(System.currentTimeMillis());

        //Изчисляваме до кога е валидна
        this.expirationDate = LocalDate.now().plusMonths(abonamentPeriod);
        this.abonamentPeriod = abonamentPeriods[abonamentPeriod];


        //this.visitsCounter = visitsCounter;
        this.CardServices = cardServices;
    }

    public Card() {
    }

    public Long getId() {
        return Id;
    }

    public int getSerialNumber() {
        return serialNumber;
    }


    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Set<Services> getCardServices() {
        return CardServices;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
