package com.creativefitness.gymapp.service;

import com.creativefitness.gymapp.model.Gym;
import com.creativefitness.gymapp.model.User;
import com.creativefitness.gymapp.repository.GymRepository;
import com.creativefitness.gymapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GymService {
    private final GymRepository gymRepository;
    private final.UserRepository userRepository;

    public Gym createGym(String ownerEmail, Gym gymDetails) {
        User owner = userRepository.findByEmail(ownerEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Owner not found"));
        
        // Ensure owner doesn't already have a gym (1-to-1 for MVP)
        if (gymRepository.findByOwnerId(owner.getId()).isPresent()) {
            throw new IllegalStateException("Owner already has a gym");
        }

        gymDetails.setOwner(owner);
        return gymRepository.save(gymDetails);
    }

    public Gym getGymByOwner(String ownerEmail) {
        User owner = userRepository.findByEmail(ownerEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Owner not found"));
        return gymRepository.findByOwnerId(owner.getId())
                .orElseThrow(() -> new RuntimeException("Gym not found for this owner"));
    }
}
