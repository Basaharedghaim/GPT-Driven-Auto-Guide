package com.carservices.finalproject.Controller;

import com.carservices.finalproject.model.Booking;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/services")
    public String services() {
        return "service";
    }

    @GetMapping("/booking")
    public String showBookingForm(Model model) {
        model.addAttribute("booking", new Booking());
        return "booking";
    }

    /*@GetMapping("/suggest")
    public String error() {
        return "suggest";
    }*/

    @GetMapping("/registration")
        public String showRegistrationForm(){
            return "register";
    }

}



