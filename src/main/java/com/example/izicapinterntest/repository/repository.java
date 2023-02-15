package com.example.izicapinterntest.repository;


import com.example.izicapinterntest.model.Question;

import java.io.IOException;

public interface repository {


    void writeCsv(Question question) throws IOException;
}
