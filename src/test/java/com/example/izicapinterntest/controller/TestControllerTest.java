package com.example.izicapinterntest.controller;

import com.example.izicapinterntest.service.StockResponseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class TestControllerTest {

    @Mock
    private StockResponseService stockResponseService;

    @InjectMocks
    private TestController testController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @Test
    public void testAnswerQuestion() throws Exception {
        String question = "{'question': 'What is the capital of France?', 'answer': 'Paris'}";
        String response = "Question added successfully!";
        Mockito.when(stockResponseService.addQuestion(question)).thenReturn(response);

        mockMvc.perform(post("/answer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(question))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
    }
}
