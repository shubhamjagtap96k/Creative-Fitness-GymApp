package com.creativefitness.gymapp.controller;

import com.creativefitness.gymapp.model.Gym;
import com.creativefitness.gymapp.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gym")
@RequiredArgsConstructor
public class GymController {
    private final GymService gymService;

    @PostMapping
    public ResponseEntity<Gym> createGym(Authentication authentication, @RequestBody Gym gym) {
        return ResponseEntity.ok(gymService.createGym(authentication.getName(), gym));
    }

    @GetMapping("/me")
    public ResponseEntity<Gym> getMyGym(Authentication authentication) {
        return ResponseEntity.ok(gymService.getGymByOwner(authentication.getName()));
    }
}
