package com.creativefitness.gymapp.repository;

import com.creativefitness.gymapp.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface GymRepository extends JpaRepository<Gym, UUID> {
    Optional<Gym> findByOwnerId(UUID ownerId);
}
