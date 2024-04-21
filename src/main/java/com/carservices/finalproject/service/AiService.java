package com.carservices.finalproject.service;

import com.carservices.finalproject.model.AiModel;
import com.carservices.finalproject.repository.AiRepository;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

@Service
public class AiService {

    private final AiRepository aiRepository;
    private String response;

    @Autowired
    public AiService(AiRepository aiRepository) {
        this.aiRepository = aiRepository;

    }

    public String prepareMessage(AiModel aiModel) {

        return "give only 5 car names that most suite for the following preferred Features .. Only There Names : " +
                "Car Type is " + aiModel.getType() +
                "and Brand is " + aiModel.getBrand() +
                "and DriveTrain " + aiModel.getMileage() +
                "price Range is " + aiModel.getPrice() +
                "Year of Manufacturing is " + aiModel.getYear() +
                "and you can have these Additional Feature " + aiModel.getSpecialAddition();
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String askChatGpt(String message) {
        String url = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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"; // API key goes here for bog
        String model = "gpt-3.5-turbo"; // current model of chatgpt api

        try {
            // Create the HTTP POST request
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", "Bearer " + apiKey);
            con.setRequestProperty("Content-Type", "application/json");

            // Build the request body
            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + message + "\"}]}";

            con.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();
            // Get the response code
            int responseCode = con.getResponseCode();
//            System.out.println("Response Code: " + responseCode);
//            System.out.println(response);;

            // Get the response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // returns the extracted contents of the response.
            return extractContentFromResponse(response.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public String extractContentFromResponse(@NotNull String response) {
        String jsonResponse = response;
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray choicesArray = jsonObject.getJSONArray("choices");
        if (choicesArray.length() > 0) {
            JSONObject firstChoice = choicesArray.getJSONObject(0);
            JSONObject message = firstChoice.getJSONObject("message");
            String content = message.getString("content");

            //System.out.println("Content: " + content);
            return content;

        } else {
           return ("No choices found ");
        }

    }
    public void saveAi(AiModel aiModel) {
        aiRepository.save(aiModel);
    }
    public AiModel getAiModelById(Long id){
        Optional<AiModel>aiModelOptional=aiRepository.findById(id);
        return aiModelOptional.orElse(null);
    }

}




