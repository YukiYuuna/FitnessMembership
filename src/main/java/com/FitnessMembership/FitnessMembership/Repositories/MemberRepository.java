package com.FitnessMembership.FitnessMembership.Repositories;

import com.FitnessMembership.FitnessMembership.Entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member , Long> {

    Optional<Member> findCustomerByFirstNameAndLastName(String firstName , String lastName);
}
