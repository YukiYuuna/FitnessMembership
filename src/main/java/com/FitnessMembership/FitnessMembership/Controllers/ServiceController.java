package com.FitnessMembership.FitnessMembership.Controllers;

import com.FitnessMembership.FitnessMembership.Entities.CardsAndServices.Card;
import com.FitnessMembership.FitnessMembership.Entities.CardsAndServices.Services;
import com.FitnessMembership.FitnessMembership.Repositories.CardsAndServices.CardRepository;
import com.FitnessMembership.FitnessMembership.Repositories.CardsAndServices.ServiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
