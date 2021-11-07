package com.FitnessMembership.FitnessMembership.Repositories;

import com.FitnessMembership.FitnessMembership.Entities.Member;

import com.FitnessMembership.FitnessMembership.Entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.Provider;

public interface ServiceRepository extends JpaRepository<Services, Long> {
}
