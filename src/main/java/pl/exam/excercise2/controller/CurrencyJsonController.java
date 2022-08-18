package pl.exam.excercise2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.exam.excercise2.exception.ExchangeRatesApiError;


public class CurrencyJsonController {
    private final ObjectMapper om = new ObjectMapper();
    private final String jsonResponse;

    public CurrencyJsonController(String jsonResponse) {
        this.jsonResponse = jsonResponse;
    }

    public double getResultFromJson() throws JsonProcessingException {
        JsonNode read = om.readTree(jsonResponse);
        if(read.get("error") != null){
            throw new ExchangeRatesApiError(read.get("error").get("message").asText());
        }
        return read.get("result").asDouble();
    }

}
