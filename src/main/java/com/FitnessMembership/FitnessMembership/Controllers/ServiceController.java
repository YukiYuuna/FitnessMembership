package com.FitnessMembership.FitnessMembership.Controllers;

import com.FitnessMembership.FitnessMembership.Entities.CardsAndServices.Card;
import com.FitnessMembership.FitnessMembership.Entities.CardsAndServices.Services;
import com.FitnessMembership.FitnessMembership.Repositories.CardsAndServices.CardRepository;
import com.FitnessMembership.FitnessMembership.Repositories.CardsAndServices.ServiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/service")

public class ServiceController {

    private final CardRepository cardRepo;
    private final ServiceRepository serviceRepo;

    public ServiceController(CardRepository cardRepo, ServiceRepository serviceRepo) {
        this.cardRepo = cardRepo;
        this.serviceRepo = serviceRepo;
    }


    @DeleteMapping("/delete")
    public ResponseEntity<?>deleteService(String serviceName) {

        Services service = serviceRepo.findServiceByServiceName(serviceName);
        Set<Card> cards = cardRepo.findAllByService(service.getServiceName());

        for (Card card : cards) {
            if (card.getService() == service)
                cardRepo.delete(card);
        }
            serviceRepo.delete(service);
            return ResponseEntity.ok("Service deleted!");
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveService(String serviceName , String description) {

        return ResponseEntity.ok(serviceRepo.save(new Services(serviceName , description)));

    }




    /*@PostMapping("save")
    public ResponseEntity<?> saveService(String serviceName, String description , Boolean isChosen)
    {
        Services service = new Services(serviceName , description , isChosen);

        if(!serviceName.isEmpty() && !description.isEmpty())
            return ResponseEntity.ok(serviceRepo.save(service));

        return ResponseEntity.ok("All field should be filled!");
    }*/


}
