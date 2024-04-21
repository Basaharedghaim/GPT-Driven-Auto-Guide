package com.carservices.finalproject.Controller;

import com.carservices.finalproject.model.AiModel;
import com.carservices.finalproject.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class AiController {
    @Autowired
    private AiService aiService;


    @GetMapping("/suggest")
    public String showCarForm(Model model){
    model.addAttribute("aiModel",new AiModel());
    return "suggest";
}
    @PostMapping("/saveAiModel")
    public String saveModel(AiModel aiModel) {
        // Ensure response is set before saving
        aiModel.setResponse(aiService.askChatGpt(aiService.prepareMessage(aiModel)));

        // Save AiModel
        aiService.saveAi(aiModel);

        // Redirect to the "/results" page
        return "results";

    }

}

