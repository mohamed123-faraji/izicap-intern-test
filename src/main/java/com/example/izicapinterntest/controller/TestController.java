package com.example.izicapinterntest.controller;

import com.example.izicapinterntest.service.StockResponseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final StockResponseService stockResponseService;

    public TestController(StockResponseService stockResponseService) {
        this.stockResponseService = stockResponseService;
    }

    @PostMapping("/answer")
    public String answerQuestion(@RequestBody String question) throws Exception {

        String response = stockResponseService.addQuestion(question);
        System.out.println(response);
        return response;
    }

}
