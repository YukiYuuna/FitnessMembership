package com.FitnessMembership.FitnessMembership.Controllers;

import com.FitnessMembership.FitnessMembership.Entities.Card;
import com.FitnessMembership.FitnessMembership.Entities.Member;
import com.FitnessMembership.FitnessMembership.Repositories.CardRepository;
import com.FitnessMembership.FitnessMembership.Repositories.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/member")
public class MemberController {

    private final MemberRepository memberRepo;
    private final CardRepository cardRepo;

    public MemberController(MemberRepository memberRepo, CardRepository cardRepo) {
        this.memberRepo = memberRepo;
        this.cardRepo = cardRepo;
    }

    @GetMapping("/fetch")
    public List<Member> GetAllMembers()
    {
        return memberRepo.findAll();
    }

    @GetMapping("/find")
    public ResponseEntity<?> findMember(String firstName , String lastName)
    {
        Optional<Member> customer = memberRepo.findCustomerByFirstNameAndLastName(firstName , lastName);
        if(customer.isEmpty())
        {
            return ResponseEntity.ok("No customer found!");
        }
        return ResponseEntity.ok(customer.get());
    }


}
