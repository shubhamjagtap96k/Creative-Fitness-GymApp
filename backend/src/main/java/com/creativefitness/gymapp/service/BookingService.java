package com.creativefitness.gymapp.service;

import com.creativefitness.gymapp.model.Booking;
import com.creativefitness.gymapp.model.BookingStatus;
import com.creativefitness.gymapp.model.ClassSession;
import com.creativefitness.gymapp.model.User;
import com.creativefitness.gymapp.repository.BookingRepository;
import com.creativefitness.gymapp.repository.ClassSessionRepository;
import com.creativefitness.gymapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final ClassSessionRepository classSessionRepository;
    private final UserRepository userRepository;

    public Booking bookClass(String userEmail, UUID classId) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        ClassSession classSession = classSessionRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));

        if (bookingRepository.existsByUserIdAndClassSessionId(user.getId(), classId)) {
            throw new RuntimeException("Already booked");
        }

        // MVP: Simple capacity check (no waitlist logic yet)
        long currentBookings = bookingRepository.findByClassSessionId(classId).stream()
                .filter(b -> b.getStatus() == BookingStatus.CONFIRMED).count();

        if (currentBookings >= classSession.getCapacity()) {
            throw new RuntimeException("Class is full");
        }

        Booking booking = Booking.builder()
                .user(user)
                .classSession(classSession)
                .status(BookingStatus.CONFIRMED)
                .build();

        return bookingRepository.save(booking);
    }

    public List<Booking> getMyBookings(String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return bookingRepository.findByUserId(user.getId());
    }
}
