package com.carservices.finalproject.service;

import com.carservices.finalproject.model.Booking;
import com.carservices.finalproject.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    public void saveBooking(Booking booking){
        bookingRepository.save(booking);

    }
    public List<Booking>getBookingByEmail(String email){
        return bookingRepository.findByEmail(email);
    }
}
