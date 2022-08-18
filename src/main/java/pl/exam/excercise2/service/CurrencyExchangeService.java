package pl.exam.excercise2.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.exam.excercise2.controller.CurrencyExchangeController;
import pl.exam.excercise2.controller.CurrencyJsonController;

import java.io.IOException;

@AllArgsConstructor
public class CurrencyExchangeService {
    @NonNull
    private CurrencyExchangeController currencyExchange;
    @NonNull
    private CurrencyJsonController currencyJson;

    public double exchange(String currencyFrom, String currencyTo, double amount) throws IOException {
        currencyExchange = new CurrencyExchangeController(currencyTo, currencyFrom, Double.toString(amount));
        currencyJson = new CurrencyJsonController(currencyExchange.getConvertRequest());
        return currencyJson.getResultFromJson();
    }
}
