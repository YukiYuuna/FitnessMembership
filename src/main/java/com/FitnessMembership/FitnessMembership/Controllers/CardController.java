package com.FitnessMembership.FitnessMembership.Controllers;

import com.FitnessMembership.FitnessMembership.Entities.CardsAndServices.Card;
import com.FitnessMembership.FitnessMembership.Entities.CardsAndServices.Services;
import com.FitnessMembership.FitnessMembership.Repositories.CardsAndServices.CardRepository;
import com.FitnessMembership.FitnessMembership.Repositories.CardsAndServices.ServiceRepository;
import com.FitnessMembership.FitnessMembership.payload.request.CardRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        if(!validateTimePeriod(cardRequest.getSubscriptionPeriod()))
        {
            return  ResponseEntity.badRequest().body("Tupi ti sa mesecite");
        }
                List<Services> services = new ArrayList<Services>();
                for (Services servicename : cardRequest.getCardServices()) {
                     Services service = serviceRepo.findServiceByServiceName(servicename.getServiceName());


                     services.add(service);
                }

                Card card = new Card(cardRequest.getSubscriptionPeriod(), services, cardRequest.isWoman());
                cardRepo.save(card);

                return ResponseEntity.ok("Ehoo prostachkoo imash karta" );
        }
    /*    public boolean validateService(Services serviceDb, Services inputService ){

        if(serviceDb.getServiceName() == inputService.getServiceName()
                && serviceDb.getDescription() == inputService.getDescription())
        return true;
        else
            return false;
        }*/

    //delete

    //tutorial hibernate & spring

    public boolean validateTimePeriod(int subscriptionPeriod){
        if(subscriptionPeriod ==1 || subscriptionPeriod == 3 || subscriptionPeriod == 6 || subscriptionPeriod == 12 )
            return true;
        else
            return false;
    }
}
