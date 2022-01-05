package com.FitnessMembership.FitnessMembership.Controllers;

import com.FitnessMembership.FitnessMembership.Entities.CardsAndServices.Card;
import com.FitnessMembership.FitnessMembership.Entities.CardsAndServices.Services;
import com.FitnessMembership.FitnessMembership.Repositories.CardsAndServices.CardRepository;
import com.FitnessMembership.FitnessMembership.Repositories.CardsAndServices.ServiceRepository;
import com.FitnessMembership.FitnessMembership.payload.request.CardRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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


    @PostMapping("/save")
    public ResponseEntity<?> saveCard(@RequestBody CardRequest cardRequest)
    {
        Set<Services> servicesSet = new HashSet<>();
        for(Services service : cardRequest.getCardServices())
        {
            servicesSet.add(service);
        }

        Card card = new Card(cardRequest.getAbonamentPeriod() , servicesSet);

        return ResponseEntity.ok("New card is saved with id: " + card.getId());
    }

}
