package com.FitnessMembership.FitnessMembership.Repositories;

import com.FitnessMembership.FitnessMembership.Entities.CardServices;
import com.FitnessMembership.FitnessMembership.Entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardServiceRepository extends JpaRepository<CardServices, Long> {
}
