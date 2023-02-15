package com.example.izicapinterntest.repository;


import com.example.izicapinterntest.model.Question;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;


import org.json.JSONObject;


@Repository
public class RepositoryImpl implements repository {

    @Value("${file-path}")
    private String path;
    private JSONArray jsonArray = null;


    @Override
    public void writeCsv(Question question) throws IOException {
        try {
            // First, try to read the existing data from the file
            try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
                String line = reader.readLine();
                StringBuilder builder = new StringBuilder();
                if (line != null) {
                    builder.append(line);
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                    }
                    reader.close();
                    String jsonStr = builder.toString();
                    jsonArray = new JSONArray(jsonStr);
                } else {
                    jsonArray = new JSONArray();
                }
            }

            // Then, create a new JSONObject and add it to the array
            JSONObject data = new JSONObject();
            data.put("question", question.getQuestion());
            data.put("answer", question.getReponse());
            jsonArray.put(data);

            // Write the updated JSON array to the file
            File file = new File(this.path);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonArray.toString(4));
            System.out.println("CSV file was updated successfully !!!");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }
}

