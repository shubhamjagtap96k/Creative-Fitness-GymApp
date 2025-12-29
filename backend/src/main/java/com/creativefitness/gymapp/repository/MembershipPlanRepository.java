package com.creativefitness.gymapp.repository;

import com.creativefitness.gymapp.model.MembershipPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface MembershipPlanRepository extends JpaRepository<MembershipPlan, UUID> {
    List<MembershipPlan> findByGymId(UUID gymId);
}
