package com.FitnessMembership.FitnessMembership.Entities.CardsAndServices;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity

public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


    private Boolean valid;

    //При всяко повторно зареждане на картата ще бъде зададена дата на зареждането в конструктора
    private Timestamp cardCharged;

    private LocalDate expirationDate;

    private int abonamentPeriod;

    //Макс брой посещения - месец

    public Card(int price) {
        Price = price;
    }

    private int Price = 0;

    private boolean gender;

    //Ще брой броя на посещенията и ще се нулира в конструктора ;)
    //private int visitsCounter;

    @OneToMany(mappedBy = "card")
    private Set<CardServices> card;

    public Set<CardServices> getCard() {
        return card;
    }

    public void setCard(Set<CardServices> card) {
        this.card = card;
    }

    /*  @ManyToMany
            @JoinTable(name = "CardServices"
            , joinColumns = @JoinColumn(name = "CardId"),
                    inverseJoinColumns = @JoinColumn(name = "ServiceId"))
        List<Services> CardServices;
*/

    //Нова карта ще създаваме само с абонаментен период и видове услуги , другите полета си ги призчисляваме
    // и са си за нас
    public Card(int abonamentPeriod ,  List<Services> cardServices , boolean gender) {
        if(gender)
        {
            Price += 40;
            //Wemen are allways right
        }
        else if(!gender)
        {
            Price += 60;
        }

     //   this.CardServices = cardServices;
        Price += 10*cardServices.size();


        //При създаване абонамента е задължителен , тъй че по дефоут е валидна
        this.valid = true;


        this.cardCharged = new Timestamp(System.currentTimeMillis());

        //Изчисляваме до кога е валидна
        this.expirationDate = LocalDate.now().plusMonths(abonamentPeriod);
        this.abonamentPeriod = abonamentPeriod;

        //this.visitsCounter = visitsCounter;
    }


    public Card() {
    }

    public Long getId() {
        return Id;
    }


    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

   /* public List<Services> getCardServices() {
        return CardServices;
    }
*/
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
