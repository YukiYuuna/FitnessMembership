package com.FitnessMembership.FitnessMembership.Controllers;

import com.FitnessMembership.FitnessMembership.Entities.CardsAndServices.Card;
import com.FitnessMembership.FitnessMembership.Entities.Member;
import com.FitnessMembership.FitnessMembership.Repositories.CardsAndServices.CardRepository;
import com.FitnessMembership.FitnessMembership.Repositories.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> GetAllMembers() {
        if (memberRepo.findAll().isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(memberRepo.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<?> findMember(String firstName, String lastName) {
        Optional<Member> customer = memberRepo.findMemberByFirstNameAndLastName(firstName, lastName);
        if (customer.isEmpty()) {
            return ResponseEntity.ok("No customer found!");
        }
        return ResponseEntity.ok(customer.get());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteMember(Long memberId){
        //Member member = memberRepo.getById(memberId);
        memberRepo.deleteById(memberId);
        return ResponseEntity.ok("member was deleted");
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveMember(String firstName, String lastName
            , String email, String address, String phoneNumber, String username, String password, Long CardId) {
        //Вземаме карта по Id понеже са предефинирани :p
        Card card = cardRepo.findById(CardId).get();

        //Ако няма друг клинт с това име го добавяме в базата данни
        if (memberRepo.findMemberByFirstNameAndLastNameAndEmailAndAddressAndPhoneNumberAndUsernameAndPassword(
                firstName, lastName, email, address, phoneNumber, username, password
        ).isEmpty()) {
            Member m = new Member(firstName, lastName, email, address, username, password, phoneNumber, card);
            memberRepo.save(m);
            return ResponseEntity.ok("Member was saved");
        } else return ResponseEntity.badRequest().body("Member  is already registered!");
    }
}


    /*public boolean isNewMember(Member member)
    {
        Optional<Member> _member = memberRepo.findMemberByFirstNameAndLastName(member.getFirstName() , member.getLastName());

        if((member.getFirstName().isEmpty())
                || (member.getAddress() != _member.get().getAddress()
                && member.getPhoneNumber() != _member.get().getPhoneNumber()
                && member.getEmail() != _member.get().getEmail())
                && member.getUsername() != _member.get().getUsername()
                && member.getPassword() != _member.get().getPassword())
        return true;

        return false;
    }


     */

