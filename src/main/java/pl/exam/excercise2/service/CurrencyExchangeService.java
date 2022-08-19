package pl.exam.excercise2.service;

import lombok.NonNull;
import pl.exam.excercise2.controller.CurrencyExchangeController;
import pl.exam.excercise2.controller.CurrencyJsonController;

import java.io.IOException;

public class CurrencyExchangeService {
    private CurrencyExchangeController currencyExchange;


    public CurrencyExchangeService(CurrencyExchangeController currencyExchange) {
        this.currencyExchange = currencyExchange;

    }

    public double exchange(String currencyFrom, String currencyTo, double amount) throws IOException {
        currencyExchange = new CurrencyExchangeController(currencyTo, currencyFrom, Double.toString(amount));
        return new CurrencyJsonController(currencyExchange.getConvertRequest()).getResultFromJson();
    }
}
