package com.creativefitness.gymapp.controller;

import com.creativefitness.gymapp.model.Booking;
import com.creativefitness.gymapp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("/class/{classId}")
    public ResponseEntity<Booking> bookClass(Authentication authentication, @PathVariable UUID classId) {
        return ResponseEntity.ok(bookingService.bookClass(authentication.getName(), classId));
    }

    @GetMapping("/me")
    public ResponseEntity<List<Booking>> getMyBookings(Authentication authentication) {
        return ResponseEntity.ok(bookingService.getMyBookings(authentication.getName()));
    }
}
