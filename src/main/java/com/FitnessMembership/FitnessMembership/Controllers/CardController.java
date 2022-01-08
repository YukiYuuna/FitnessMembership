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



    @PostMapping( "/save" )
    public ResponseEntity<?> saveCard(@RequestBody CardRequest cardRequest)
    {


        if(validateTimePeriod(cardRequest.getAbonamentPeriod()) == false)
        {
            return ResponseEntity.ok("Tupi ti sa mesecite");
        }
                List<Services> servicesSet = new ArrayList<Services>();
                for (Services servicename : cardRequest.getCardServices()) {
                     Services service = serviceRepo.findServiceByServiceName(servicename.getServiceName());
                     servicesSet.add(service);
                }

                Card card = new Card(cardRequest.getAbonamentPeriod(), servicesSet);
                cardRepo.save(card);

                return ResponseEntity.ok("Ehoo prostachkoo imash karta");

        }



    public boolean validateTimePeriod(int abonamentPeriod){
        if(abonamentPeriod ==1 || abonamentPeriod == 3 || abonamentPeriod == 6 || abonamentPeriod == 12 )
            return true;
        else
            return false;

    }
}
