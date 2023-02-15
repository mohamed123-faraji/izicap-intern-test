package com.example.izicapinterntest.service;

import com.example.izicapinterntest.model.Question;
import com.example.izicapinterntest.repository.RepositoryImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StockResponseService {

    private final RepositoryImpl repository;
    private final GetResponseService getResponseService;


    public StockResponseService(RepositoryImpl repository, GetResponseService getResponseService) {
        this.repository = repository;
        this.getResponseService = getResponseService;
    }

    public String addQuestion(String question) throws IOException {
        String response = getResponseService.getReponse(question);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response);
        String textResponse = rootNode.get("choices").get(0).get("text").asText();
        String text = textResponse.replaceAll("\n"," ");

        Question question1 = new Question();
        question1.setQuestion(question);
        question1.setReponse(text);
        repository.writeCsv(question1);
        return response;
    }
}
