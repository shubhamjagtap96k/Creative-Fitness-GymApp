package com.creativefitness.gymapp.repository;

import com.creativefitness.gymapp.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
    List<Booking> findByUserId(UUID userId);

    List<Booking> findByClassSessionId(UUID classId);

    boolean existsByUserIdAndClassSessionId(UUID userId, UUID classId);
}
