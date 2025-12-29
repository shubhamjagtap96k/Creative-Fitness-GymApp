package com.creativefitness.gymapp.controller;

import com.creativefitness.gymapp.model.ClassSession;
import com.creativefitness.gymapp.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/classes")
@RequiredArgsConstructor
public class ClassController {
    private final ClassService classService;

    @PostMapping
    public ResponseEntity<ClassSession> createClass(Authentication authentication,
            @RequestBody ClassSession classSession) {
        return ResponseEntity.ok(classService.createClass(authentication.getName(), classSession));
    }

    @GetMapping("/owner")
    public ResponseEntity<List<ClassSession>> getMyClasses(Authentication authentication) {
        return ResponseEntity.ok(classService.getAllClassesForOwner(authentication.getName()));
    }

    @GetMapping("/gym/{gymId}")
    public ResponseEntity<List<ClassSession>> getClassesByGym(@PathVariable UUID gymId) {
        return ResponseEntity.ok(classService.getClassesForGym(gymId));
    }
}
