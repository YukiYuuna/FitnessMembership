package com.FitnessMembership.FitnessMembership.Entities;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    private String firstName;

    private String lastName;

    private String Email;

    private String username;

    private String password;

    private String phoneNumber;

    @ManyToOne
    private Card card = new Card();

    public Long getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Member() {
    }

    public Member(String firstName, String lastName, String email, String username, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.card = card;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}
