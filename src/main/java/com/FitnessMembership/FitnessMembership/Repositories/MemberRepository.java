package com.FitnessMembership.FitnessMembership.Repositories;

import com.FitnessMembership.FitnessMembership.Entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member , Long> {

    Optional<Member> findMemberByFirstNameAndLastName(String firstName , String lastName);

    Optional<Member> findMemberByFirstNameAndLastNameAndEmailAndAddressAndPhoneNumberAndUsernameAndPassword(
            String firstName , String lastName , String Email,
            String Address , String phoneNumber , String username , String password);

}
