package pl.exam.exercise2.controller;

import java.io.*;
import java.util.Objects;

import okhttp3.*;
import pl.exam.exercise2.configuration.Configuration;

public class CurrencyExchangeController {
    private final Configuration configuration;

    public CurrencyExchangeController(Configuration configuration) {
        this.configuration = configuration;
    }

    public String getConvertRequest(String currencyTo, String currencyFrom, double amount) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(configuration.getApiUrl() + "convert?to=" + currencyTo + "&from=" + currencyFrom + "&amount=" + amount)
                .addHeader("apikey", configuration.getApiKey())
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return Objects.requireNonNull(response.body()).string();
    }
}
