package com.creativefitness.gymapp.repository;

import com.creativefitness.gymapp.model.ClassSession;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ClassSessionRepository extends JpaRepository<ClassSession, UUID> {
    List<ClassSession> findByGymIdAndStartTimeBetween(UUID gymId, LocalDateTime start, LocalDateTime end);

    List<ClassSession> findByGymId(UUID gymId);
}
