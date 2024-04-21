package com.carservices.finalproject.Controller;

import com.carservices.finalproject.model.Booking;
import com.carservices.finalproject.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public String processBookingForm(@ModelAttribute("booking") Booking booking) {
        // Process the booking data, e.g., save to a database
        bookingService.saveBooking(booking);
        return "booking";

    }
    @GetMapping("/reservation")
    public String showResirvationByEmail(@RequestParam("email")String email, Model model){
        List<Booking>bookings =bookingService.getBookingByEmail(email);
        model.addAttribute("bookings",bookings);
        return "reservation";
    }

}
