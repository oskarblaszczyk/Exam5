package pl.exam.exercise2.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.exam.exercise2.controller.CurrencyExchangeController;
import pl.exam.exercise2.exception.ExchangeRatesApiError;

import java.io.IOException;

public class CurrencyExchangeService {
    private final CurrencyExchangeController currencyExchangeController;
    private final ObjectMapper objectMapper;

    public CurrencyExchangeService(CurrencyExchangeController currencyExchangeController, ObjectMapper objectMapper) {
        this.currencyExchangeController = currencyExchangeController;
        this.objectMapper = objectMapper;
    }

    public double exchange(String currencyFrom, String currencyTo, double amount) throws IOException {
        String response = currencyExchangeController.getConvertRequest(currencyTo, currencyFrom, amount);
        JsonNode read = objectMapper.readTree(response);
        if (read.get("error") != null) {
            throw new ExchangeRatesApiError(read.get("error").get("message").asText());
        }
        return read.get("result").asDouble();
    }
}
