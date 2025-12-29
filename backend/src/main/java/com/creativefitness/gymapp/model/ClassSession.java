package com.creativefitness.gymapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classes")
public class ClassSession { // Renamed from Class to avoid Java keyword conflict
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;

    @Column(nullable = false)
    private String title;

    private String description;
    private String trainerName;
    private String room;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private Integer capacity;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
