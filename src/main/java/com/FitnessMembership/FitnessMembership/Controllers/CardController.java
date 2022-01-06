package com.FitnessMembership.FitnessMembership.Controllers;

import com.FitnessMembership.FitnessMembership.Entities.CardsAndServices.Card;
import com.FitnessMembership.FitnessMembership.Entities.CardsAndServices.Services;
import com.FitnessMembership.FitnessMembership.Repositories.CardsAndServices.CardRepository;
import com.FitnessMembership.FitnessMembership.Repositories.CardsAndServices.ServiceRepository;
import com.FitnessMembership.FitnessMembership.payload.request.CardRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/card")
public class CardController {

    private final CardRepository cardRepo;
    private final ServiceRepository serviceRepo;

    public CardController(CardRepository cardRepo, ServiceRepository serviceRepo) {
        this.cardRepo = cardRepo;
        this.serviceRepo = serviceRepo;
    }


    @PostMapping(value = "/save" ,
    consumes = {
        MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CardRequest> saveCard(@RequestBody CardRequest cardRequest)
    {
        List<Services> servicesSet = new ArrayList<Services>();
        for(Services service : cardRequest.getCardServices())
        {
            servicesSet.add(service);
        }

        Card card = new Card(cardRequest.getAbonamentPeriod() , servicesSet);

        return ResponseEntity.ok(cardRequest);
    }
}
