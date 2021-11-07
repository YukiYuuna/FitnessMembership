package com.FitnessMembership.FitnessMembership.Repositories;

import com.FitnessMembership.FitnessMembership.Entities.Card;
import com.FitnessMembership.FitnessMembership.Entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
