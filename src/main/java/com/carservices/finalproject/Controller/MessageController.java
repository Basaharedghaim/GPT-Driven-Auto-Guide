package com.carservices.finalproject.Controller;

import com.carservices.finalproject.model.Messages;
import com.carservices.finalproject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class MessageController {
    private MessageService messageService;
    @Autowired
    public MessageController(MessageService messageService){
        this.messageService=messageService;
    }


    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("messages", new Messages());
        return "contact"; // Assuming the Thymeleaf template is named "contact.html"
    }

    @PostMapping("/sendMessage")
    public String sendMessage(Messages messageEntity) {
        messageService.saveMessage(messageEntity);
        return "redirect:/contact?success"; // Redirect to the contact page with a success parameter
    }
}
