package com.FitnessMembership.FitnessMembership.Repositories.CardsAndServices;

import com.FitnessMembership.FitnessMembership.Entities.CardsAndServices.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {


}
