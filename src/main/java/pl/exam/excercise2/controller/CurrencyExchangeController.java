package pl.exam.excercise2.controller;

import java.io.*;
import java.util.Objects;

import okhttp3.*;

public class CurrencyExchangeController {
    private final String url = "https://api.apilayer.com/exchangerates_data/";
    private final String apiKey = "aqxzA1Fk9wdG3pGYSQQDjOsEJA9sa5sY";
    private final String currencyTo;
    private final String currencyFrom;
    private final String amount;

    public CurrencyExchangeController(String currencyTo,String currencyFrom,String amount) {
        this.currencyTo = currencyTo;
        this.currencyFrom = currencyFrom;
        this.amount = amount;
    }

    public String getConvertRequest() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(url + "convert?to=" + currencyTo + "&from=" + currencyFrom + "&amount=" + amount)
                .addHeader("apikey", apiKey)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return Objects.requireNonNull(response.body()).string();
    }
}
