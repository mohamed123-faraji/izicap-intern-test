package com.example.izicapinterntest.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class GetResponseService {


    @Value("${apikey}")
    private String apiKey;

    @Value("${endpoint}")
    private String endpoint;

    private final RestTemplate restTemplate;

    public GetResponseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    public String getReponse(String question)
    {


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);
        String request = "{\"model\": \"text-davinci-003\",\"prompt\":\"" + question + "\",\"max_tokens\":4000,\"temperature\":1.0}";
        HttpEntity<String> entity = new HttpEntity<>(request, headers);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(endpoint, entity, String.class);
        return response;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getEndpoint() {
        return this.endpoint;
    }
}
