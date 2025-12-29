package com.creativefitness.gymapp.service;

import com.creativefitness.gymapp.model.ClassSession;
import com.creativefitness.gymapp.model.Gym;
import com.creativefitness.gymapp.repository.ClassSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClassService {
    private final ClassSessionRepository classSessionRepository;
    private final GymService gymService;

    public ClassSession createClass(String ownerEmail, ClassSession classDetails) {
        Gym gym = gymService.getGymByOwner(ownerEmail);
        classDetails.setGym(gym);
        return classSessionRepository.save(classDetails);
    }

    public List<ClassSession> getClassesForGym(UUID gymId) {
        return classSessionRepository.findByGymId(gymId);
    }

    public List<ClassSession> getAllClassesForOwner(String ownerEmail) {
        Gym gym = gymService.getGymByOwner(ownerEmail);
        return classSessionRepository.findByGymId(gym.getId());
    }
}
